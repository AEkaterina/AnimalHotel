import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    static final String TOKEN = "1935328477:AAGfhLfY1tJO-aK6YzBVIHhHXHuyVzCHfsY";
    static final String USERNAME = "AstAnimalHotelBot";

    long chat_id;
    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
    @Override
    public void onUpdateReceived(Update update) {
        chat_id = update.getMessage().getChatId();

        SendMessage sendMessage = new SendMessage().setChatId(chat_id).setText(getMessage(update.getMessage().getText()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try{
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    String getMessage(String message) {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        KeyboardRow keyboardThirdRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        if(message.equals("/start")) {
            keyboard.clear();
            keyboardFirstRow.add("О нас \uD83C\uDFE0");
            keyboardFirstRow.add("Услуги и цены \uD83D\uDCB5");
            keyboardFirstRow.add("Правила приема \uD83D\uDCC3");
            keyboardSecondRow.add("Вопрос-ответ ❓");
            keyboardSecondRow.add("Контакты \uD83D\uDC40");
            keyboardThirdRow.add("Забронировать \uD83D\uDCBB");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardThirdRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Здравствуйте!\n" +
                    "Добро пожаловать в гостиницу для собак, кошек и других домашних животных.\n" +
                    "Пока Вы отдыхаете мы заботимся о ваших любимцах 24 часа в сутки\n" +
                    "Выберете, что вас интересует";
        }

        if (message.equals("Меню")) {
            keyboard.clear();
            keyboardFirstRow.add("О нас \uD83C\uDFE0");
            keyboardFirstRow.add("Услуги и цены \uD83D\uDCB5");
            keyboardFirstRow.add("Правила приема \uD83D\uDCC3");
            keyboardSecondRow.add("Вопрос-ответ ❓");
            keyboardSecondRow.add("Контакты \uD83D\uDC40");
            keyboardThirdRow.add("Забронировать \uD83D\uDCBB");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            keyboard.add(keyboardThirdRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Выберете, что вас интересует";
        }

        if(message.equals("Услуги и цены \uD83D\uDCB5")) {
            keyboard.clear();
            keyboardFirstRow.add("Собака \uD83D\uDC36");
            keyboardFirstRow.add("Кошка \uD83D\uDC31");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Какое у вас животное?";
        }

        if(message.equals("Собака \uD83D\uDC36")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Пока ничего(";
        }

        if(message.equals("Кошка \uD83D\uDC31")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Пока ничего(";
        }

        if(message.equals("Правила приема \uD83D\uDCC3")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Мы принимаем в нашу гостиницу собак и кошек любого возраста, породы и размера.\n" +
                    "Уютная домашняя атмосфера, отдельные номера, опытный и заботливый персонал позволяют нам принимать течных животных, а так же котят и щенков.\n" +
                    "Мы готовы разместить в нашей гостинице собаку или кошку на любой срок.\n" +
                    "При размещении в гостинице хозяин животного заполняет памятку в которой указывает:\n" +
                    "\n" +
                    "— Кличку животного.\n" +
                    "— Возраст.\n" +
                    "— Режим кормления животного.\n" +
                    "— Рецепт приготовления пищи (в случае натурального кормления)\n" +
                    "— Марку и вид корма (в случае питания животного сухим кормом)\n" +
                    "— Режим выгула.\n" +
                    "— Особенности и привычки животного, состояние здоровья.\n" +
                    "— Контактные данные владельца.\n" +
                    "— Контактные телефоны лечащего вет. врача.";
        }

        if(message.equals("Вопрос-ответ ❓")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "1. ЧТО С СОБОЙ ПРИВЕЗИТИ?" +
                    "\nСобирайте Вашего любимца в дорогу как любого «курортника». " +
                    "\nЕсли у Вас собака, привозите с собой ее «место» для отдыха, какую-либо вещь с запахом хозяина для «душевного равновесия»." +
                    "Если у нее есть привычная миска, захватите с собой. Возьмите парочку любимых игрушек." +
                    "\nДля кошки рекомендуется так же взять миску, любимую игрушку, корм на весь период пребывания, в случае если Ваш питомец предпочитает " +
                    "определенный корм. Лоточек, наполнитель, совок, миски, игрушки предоставляются." +
                    "\nРодословная и прочие документы на животное — НЕ нужны. Зато составьте подробнейший отчёт о своём питомце. Чем больше напишете, " +
                    "тем лучше. Обязательна информация о хронических заболеваниях, кикие-либо привычки (любит ли прыгать через барьер, грызть и т. д." +
                    "\n\n" +
                    "2. ГДЕ БУДЕТ СПАТЬ МОЙ ЛЮБИМЕЦ?" +
                    "\nНа улице никто не ночует. У каждого питомца в нашей гостинице есть своё персональное место исключительно в доме. Подробнее можете прочитать в разделе " +
                    "\"Условия проживания\"(О нас)" +
                    "\n\n" +
                    "3. ЧЕМ КОРМЯТ В ГОСТИНИЦЕ?" +
                    "\nИдеальный вариант — сохранение привычной для Вашего питомца домашней пищевой программы.  Это позволяет избежать аллергической реакции и лишнего стресса. " +
                    "Если Ваш питомец ест определенный корм, лучше взять его с собой. Мы не навязываем что-то одно и не зарабатываем на этом. Если Вы забыли или не " +
                    "успели купить корм, можно заказать  с доставкой тот, который Вы хотите. Если надо готовить, то привозите свои крупы, замороженное мясо, курицу " +
                    "или субпродукты. Мы всё приготовим. При необходимости обеспечим своим питанием: сухой корм, влажный корм, рыба, мясо, каша. " +
                    "\n\n" +
                    "4. А ЕСЛИ ЗАБОЛЕЛ?" +
                    "При необходимости мы обеспечены квалифицированной ветеринарной помощью. У нас работает квалифицированный ветеринар. По желанию ветеринар может быть тот, которого укажете Вы сами. " +
                    "Главное, чтобы он выезжал на визиты." +
                    "\n\n" +
                    "5. ЧТО ДЕЛАТЬ ЕСЛИ ПРОЖИВАНИЯ НУЖНО ПРОДЛИТЬ, А КОРМ ЗАКОНЧИЛСЯ?" +
                    "\nКорм всегда есть в наличии, Ваш любимец ни в коем случае не останется без еды. При выселении производится оплата за дополнительные дни проживания, " +
                    "а так же за предоставленный корм." +
                    "\n\n" +
                    "6. ВОЗМОЖНО ЛИ ПРОДЛЕНИЕ ПРОЖИВАНИЯ ПИТОМЦА?" +
                    "\nДа, такая возможность есть при наличии свободных номеров. Оплата за период проживания производится в момент выселения." +
                    "7. НЕОБХОДИМО ЛИ ЗАКЛЮЧЕНИЕ ДОГОВОРА?" +
                    "\nКонечно, в гостинице будет составлен договор на оказание услуг. Счет оплачивается в момент заселения. Так же мы подпишем с Вами акт-анкету приема питомца, " +
                    "а после Вашего возвращения акт-возврат.";
        }

        if(message.equals("Контакты \uD83D\uDC40")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Наша гостиница для животных расположена в деревне Новый Двор, ул. Рождественская 8.\n" +
                    "\n" +
                    "Телефоны для связи:\n" +
                    "\uD83D\uDCF1   +375 (29) 145-53-50 | +375 (29) 734-99-01\n" +
                    "☎️   +375 (17) 127-15-60" +
                    "\nПРОСИМ перед звонком ознакомиться с разделом ПРАВИЛА ПРИЕМА" +
                    "\nE-mail ✉️ AnimalHotel@gmail.com" +
                    "\n\nИз Минска в деревню \"Новый Двор\" можно добраться:\n" +
                    "На общественном транспорте  \uD83D\uDE8C\n" +
                    "Автобусы №85-c (от ЖД вокзала) и №108 (от ст.м. Могилевская).\n" +
                    "Остановка \"Поворот на Новый Двор\"\n" +
                    "\n" +
                    "На личном транспорте \uD83D\uDE97\n" +
                    "г. Минск - МКАД (район Лошица, Чижовка) - указатель на Михановичи / Гатово - указатель на Новый Двор" +
                    "\n\nРаботаем круглосуточно";
        }

        if(message.equals("Забронировать \uD83D\uDCBB")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Пока ничего нет(";
        }

        if (message.equals("О нас \uD83C\uDFE0")) {
            keyboard.clear();
            keyboardFirstRow.add("Условия содержания");
            keyboardFirstRow.add("Галерея");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "В нашей гостинице для животных:\n" +
                    "Собственный ветеринарный кабинет\n" +
                    "Выгул 3 раза в день в собственном огороженном дворе\n" +
                    "Домашняя обстановка проживания (без клеток)\n" +
                    "Беговая дорожка\n" +
                    "Индивидуальный рацион\n" +
                    "Ежедневный фотоотчет + мы всегда на связи";
        }

        if(message.equals("Условия содержания")) {
            keyboard.clear();
            keyboardFirstRow.add("Для кошек \uD83D\uDC31");
            keyboardFirstRow.add("Для собак \uD83D\uDC36");
            keyboardSecondRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Во всех помещениях для животных регулярно проводится уборка и санобработка. \nВо время пребывания возможно проведение вакцинации.";
        }

        if (message.equals("Для кошек \uD83D\uDC31")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Коты/кошки (в т.ч. котята) \uD83D\uDC31" +
                    "\nВ нашей гостинице:" +
                    "\n3 вольера с лесенками и домиком, игрушками\n" +
                    "6 комнат с диваном, полками и игрушками\n" +
                    "Если ваша кошка привыкла к прогулкам, можно организовать ее выгул (на поводке, со шлейкой). \uD83D\uDC08 " +
                    "\nПитание кошки получают в соответствии с желанием хозяина.";
        }

        if (message.equals("Для собак \uD83D\uDC36")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Собаки(в т.ч. щенки) \uD83D\uDC36" +
                    "\nВ нашей гостинице: " +
                    "\n6 просторных комнат с удобным мягким диваном, полками и игрушками\n" +
                    "6 Уличных вольеров\n" +
                    "Выгул собак осуществляется три раза в день. \uD83E\uDDAE" +
                    "\nПитание собаки получают в соответствии с желанием хозяина. \uD83C\uDF56\n" +
                    "По запросу владельца собаки возможно проведение курса дрессировки либо разовые занятия по корректировке поведения. " +
                    "Обучение проводят профессиональные дрессировщики. \uD83E\uDD4E";
        }

        if(message.equals("Галерея")) {
            keyboard.clear();
            keyboardFirstRow.add("Меню");
            keyboard.add(keyboardFirstRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return "Пока ничего нет(";
        }

        return "Если возникли проблемы, воспользуйтесь /start";
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }
}
