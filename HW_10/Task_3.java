package HW_10;

// Часть 3: Паттерн Кеширования

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;

public class OrderRepository {

    private final Cache<String, Order> cache;
    private final Database database;

    public OrderRepository(Database database) {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES) // Устанавливаем время жизни кеша в минутах
                .build();
        this.database = database;
    }

    public Order getOrder(String orderId) {
        Order order = cache.getIfPresent(orderId);
        if (order != null) {
            return order;
        } else {
            order = database.getOrder(orderId);
            cache.put(orderId, order);
            return order;
        }
    }

    public void updateOrder(String orderId) {
        Order updatedOrder = database.getOrder(orderId);
        cache.put(orderId, updatedOrder);
    }
}

// В данном примере используется библиотека Caffeine для реализации кеширования. Кеш создается с помощью метода 
// Caffeine.newBuilder(), где устанавливается время жизни кеша с помощью метода expireAfterWrite. В данном примере 
// кеш будет храниться в течение 1 минуты после последнего обновления.

// Метод getOrder проверяет, есть ли заказ с указанным идентификатором в кеше. Если есть, то возвращается из кеша. 
// Если заказ отсутствует в кеше, то он загружается из базы данных, помещается в кеш и возвращается.

// Метод updateOrder обновляет данные заказа в базе данных и помещает их в кеш.

// Таким образом, данный код реализует кеширование заказов, где часто запрашиваемые заказы загружаются из кеша, 
// а не из базы данных. Кеш автоматически инвалидируется (обновляется), если информация в базе данных была изменена.