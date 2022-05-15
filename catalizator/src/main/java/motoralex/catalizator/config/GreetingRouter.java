package motoralex.catalizator.config;

import motoralex.catalizator.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;

import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        RequestPredicate route = RequestPredicates
        .GET("/hello").
                and(RequestPredicates.accept(MediaType.TEXT_PLAIN));
        return RouterFunctions
                .route(route, greetingHandler::hello)
                .andRoute(
                        RequestPredicates.GET("/"),
                        greetingHandler::index
                );
    }
}