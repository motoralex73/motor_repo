package motoralex.catalizator.handler;

import motoralex.catalizator.domain.Mesage;

//import org.apache.logging.log4j.message.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        Flux<Mesage> data = Flux
                .just(
                        "Hello, reactive!",
                        "More then one",
                        "Third post",
                        "Fourth post",
                        "Fifth post"
                )
                .map(Message::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Mesage.class);
    }
    public Mono<ServerResponse> index (ServerRequest serverRequest) {
        String user = serverRequest.queryParam("user")
                .orElse("Nobody");
        return ServerResponse
                .ok()
                .render("index", Map.of("user",user));
    }

}