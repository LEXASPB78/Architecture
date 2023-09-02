/*
 * ### **Задание:**

h. Спроектировать компонент подключения по API к производителю роботов-пылесосов, для обновления прошивок и 
передачи диагностических данных https://app.diagrams.net/.

i. Спроектировать адаптеры интерфейсов в виде компонент (подключение к БД, шлюзы к интерфейсу, шлюзы к третьим 
источникам) https://app.diagrams.net/.

j. Спроектировать компонент внешнего конфигурирования для настройки компонент бизнес-логики (параметры конкретного 
робота) https://app.diagrams.net/.

k. Спроектировать и имплементировать компонент самодиагностики (Self-checking). Который собирает статус 
работоспоспособности и времени запроса на каждый компонент уровня API Gateway, бизнес-логики и слоя управления данными. Включая технологический интерфейс для мониторинга https://grafana.com/ или https://prometheus.io/ .

l. Выбрать метрики для наблюдения за инфраструктурой на которой будет развёрнуто решение (процессор, память, 
диск).
 */

package HW_12;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

public class MetricsCollector {
    private static final MeterRegistry registry = new SimpleMeterRegistry();
    private static final Counter requestsCounter = Counter.builder("requests")
            .description("Total number of requests")
            .tag("component", "API Gateway")
            .register(registry);
    private static final Timer requestTimer = Timer.builder("request_duration")
            .description("Request duration in milliseconds")
            .tag("component", "API Gateway")
            .register(registry);

    public void collectMetrics() {
        // Сбор и запись показателей для API Gateway

        // Увеличение счетчика для каждого запроса
        requestsCounter.increment();

        // Запуск таймера для измерения продолжительности запроса
        Timer.Sample sample = Timer.start(registry);

        // Обработка запроса

        // Остановка таймера и запись продолжительности
        sample.stop(requestTimer);
    }

    public static void main(String[] args) {
        MetricsCollector collector = new MetricsCollector();
        collector.collectMetrics();

        // Экспорт показателей в Prometheus или Grafana
        registry.scrape();
    }
}