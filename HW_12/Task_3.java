/*
 m. Разработать Unit Test для сервисов бизнес-логики.

n. Предложить и разработать E2E тесты https://www.postman.com/ или аналоги.

o. Предложить и разработать приёмочные тесты (UAT) для сценариев Use case https://www.gurock.com/testrail/ 
или аналоги.

p. Предложить тесты для регрессионного тестирования.
 */

package HW_12;

import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessLogicServiceTest {

    @Test
    public void testBusinessLogicService() {
        // Организация
        BusinessLogicService businessLogicService = new BusinessLogicService();
        // Действие
        String result = businessLogicService.someMethod();
        // Утверждение
        assertEquals("expectedResult", result);
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class EndToEndTest {

    @Test
    public void testEndToEnd() {
        // Организация
        // Инициализация необходимых ресурсов
        // Действие
        // Выполнение сквозного тестового сценария
        // Утверждение
        // Проверка ожидаемого результата
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class UserAcceptanceTest {

    @Test
    public void testUserAcceptance() {
        // Организация
        // Инициализация необходимых ресурсов
        // Действие
        // Выполнение тестирования пользователя
        // Утверждение
        // Проверка ожидаемого результата
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class RegressionTest {

    @Test
    public void testRegression() {
        // Организация
        // Инициализация необходимых ресурсов
        // AДействиеct
        // Выполнение регрессионного тестирования
        // Утверждение
        // Проверка ожидаемого результата
    }
}