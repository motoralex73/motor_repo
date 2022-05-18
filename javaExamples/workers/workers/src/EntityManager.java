import many_workers.Employer;

import java.lang.reflect.Array;

public class EntityManager<T extends Employer> {
    private T[] entities;
    int size;

    public T[] getEntities() {
        return entities;
    }

    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public EntityManager(int maxSize, Class<Employer> tClass) {
        this.entities = (T[])Array.newInstance(tClass, maxSize);
    }

    public void addEntities(T entity) {
        System.out.println(entity.getName()+" is added");
        entities[size] = entity;
        size++;
    }

}
