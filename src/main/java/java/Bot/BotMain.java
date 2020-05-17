package java.Bot;

import TajribaUchun.BotTajriba;
import lombok.SneakyThrows;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotMain extends TelegramLongPollingBot {
    SendMessage sendMessage=new SendMessage();
    public static void main(String[] args) throws TelegramApiRequestException {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new BotTajriba());

    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){


//            System.out.println(update.getMessage().getChatId());
            if (update.getMessage().getText().equals("/start")){
                sendMessage.setChatId(update.getMessage().getChatId());
                System.out.println("id = "+update.getMessage().getFrom().getId());
                System.out.println(update.getMessage().getFrom().getUserName());
                System.out.println(update.getMessage().getFrom().getFirstName());
                System.out.println(update.getMessage().getFrom().getLastName());
                sendMessage.setText("Javoblarni quyidagi ko'rinishda jo'nating:\n(test raqami)(kalitlar)\nMasalan:\n2abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd");
                execute(sendMessage);
            }
            else {

            }

        }
    }

    @Override
    public String getBotUsername() {
        return "testishla_bot";
    }

    @Override
    public String getBotToken() {
        return "677672469:AAFAhMvAXpia_lC-4QrwyZxrEG41BIFGBcY";
    }
}
