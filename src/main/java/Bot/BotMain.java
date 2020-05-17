package Bot;

import TajribaUchun.BotTajriba;
import lombok.SneakyThrows;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class BotMain extends TelegramLongPollingBot {
    SendMessage sendMessage=new SendMessage();
    Methods methods=new Methods();

    public static void main(String[] args) throws TelegramApiRequestException {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramBotsApi.registerBot(new BotMain());

    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        User user=new User();
//        System.out.println(update.getMessage().getDate().longValue());

//        System.out.println(update.getMessage().getDate().doubleValue());

        if (!update.hasEditedMessage()){
            if (!methods.findUser(String.valueOf(update.getMessage().getFrom().getId()))){
                user.setTgID(String.valueOf(update.getMessage().getFrom().getId()));
                user.setUserName(update.getMessage().getFrom().getUserName());
                user.setFirstName(update.getMessage().getFrom().getFirstName());
                user.setLastName(update.getMessage().getFrom().getLastName());
                methods.addUser(user);
            }
            else {
                user.setTgID(String.valueOf(update.getMessage().getFrom().getId()));
                user.setUserName(update.getMessage().getFrom().getUserName());
                user.setFirstName(update.getMessage().getFrom().getFirstName());
                user.setLastName(update.getMessage().getFrom().getLastName());
                methods.changeUserInformation(user);
            }
        }
        else {
            if (!methods.findUser(String.valueOf(update.getEditedMessage().getFrom().getId()))){
                user.setTgID(String.valueOf(update.getEditedMessage().getFrom().getId()));
                user.setUserName(update.getEditedMessage().getFrom().getUserName());
                user.setFirstName(update.getEditedMessage().getFrom().getFirstName());
                user.setLastName(update.getEditedMessage().getFrom().getLastName());
                methods.addUser(user);
            }
            else {
                user.setTgID(String.valueOf(update.getEditedMessage().getFrom().getId()));
                user.setUserName(update.getEditedMessage().getFrom().getUserName());
                user.setFirstName(update.getEditedMessage().getFrom().getFirstName());
                user.setLastName(update.getEditedMessage().getFrom().getLastName());
                methods.changeUserInformation(user);
            }
        }
        System.out.println(update.getMessage().getDate());
        if (update.getMessage().getDate()>1589646600&&update.getMessage().getDate()<1589653800){
            if (update.hasMessage()){

//            System.out.println(update.getEditedMessage().getText());
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setReplyToMessageId(update.getMessage().getMessageId());
//            System.out.println(update.getMessage().getChatId());
                if (update.getMessage().getText().equals("/start")){



                    System.out.println("id = "+update.getMessage().getFrom().getId());
                    System.out.println(update.getMessage().getFrom().getUserName());
                    System.out.println(update.getMessage().getFrom().getFirstName());
                    System.out.println(update.getMessage().getFrom().getLastName());
                    sendMessage.setText("Javoblarni quyidagi ko'rinishda jo'nating:\n*(test raqami)(kalitlar)*\nMasalan:\n*2abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd*\n\n*❗️️Javoblar 1 marta qabul qilinadi❗️*");
                    execute(sendMessage);


                }
                else {
                    user.setAnswer(update.getMessage().getText().toLowerCase());
                    user.setTgID(String.valueOf(update.getMessage().getFrom().getId()));
                    if (methods.Tekshiruvchi(user)){
                    sendMessage.setText("Javoblaringiz qabul qilindi!\nNatijalar tez orada kanalimizda e'lon qilinadi.\nKanalimiz:\n\uD83D\uDC49 https://t.me/asosiybloklitestlar");
                        execute(sendMessage);
                    }
                    else {
                    sendMessage.setText("Kechirasiz! Javoblar noto'g'ri formatda kiritilgan:\n - Siz bu testni oldin ishlagan bo'lishingiz mumkin!\n - Bu testning muddati tugagan bo'lishi mumkin!\nAgar yuqoridagi sabablar asossiz boʻlsa javoblarni qaytadan toʻgʻrilab yuborib koʻring.");
                        execute(sendMessage);
                    }

                }

            }
        }
        else {
            if(update.getMessage().getDate()>1589653800){
                System.out.println(update.getMessage().getFrom().getFirstName());
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setReplyToMessageId(update.getMessage().getMessageId());
                sendMessage.setText("Tez orada yangi onlayn test bo'lib o'tadi!\nJavoblaringiz oʻsha vaqtda qabul qilinadi!\nTest boʻlib oʻtadigan kanalimiz \uD83D\uDC49 https://t.me/asosiybloklitestlar");
                execute(sendMessage);
            }
            else {
                System.out.println(update.getMessage().getFrom().getFirstName());
                sendMessage.setChatId(update.getMessage().getChatId());
                sendMessage.setReplyToMessageId(update.getMessage().getMessageId());
                sendMessage.setText("1-onlayn test 16 may soat 21:30 - 23:30 oralig'ida bo'lib o'tadi\nJavoblaringiz oʻsha vaqtda qabul qilinadi!\nTest boʻlib oʻtadigan kanalimiz \uD83D\uDC49 https://t.me/asosiybloklitestlar");
                execute(sendMessage);
            }

        }


    }

    @Override
    public String getBotUsername() {
        return "testishla_bot";
    }

    @Override
    public String getBotToken() {
        return "677672469:AAFAm-JXzg18Lik4F-9ql1KIop9XDDNPTKk";
    }
}
