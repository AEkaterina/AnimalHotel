import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        Bot bot = new Bot();
        try {
            telegramBotsApi.registerBot(bot);
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
