package sg.whirl.pdp_spring.beans;

import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemFactory implements FactoryBean<Item> {

    private AtomicInteger lastCounter = new AtomicInteger(0);

    @Override
    public Item getObject() {
        return new Item(lastCounter.incrementAndGet());
    }

    @Override
    public Class<?> getObjectType() {
        return Item.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
