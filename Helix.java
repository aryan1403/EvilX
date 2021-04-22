

import java.io.File;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.PromoteChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.ChatMember;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Helix extends TelegramLongPollingBot{

    int spamno = 0;
    String spamtext = "";
    String link = "";
    boolean isinvitelinkset = false;
    String botextendedcmd = "@EvilX_bot";
    boolean stop = false;
    @Override
    public void onUpdateReceived(Update update) {
        String cmd = update.getMessage().getText();
        if(cmd.equals("/start")||cmd.equals("/start"+botextendedcmd))
        {
            if(update.getMessage().getChat().isUserChat() == true) sendmsg(update.getMessage().getChatId().toString(), "Hi "+getFirstName(update)+"\n@EvilX_bot on Fire.\nCommand me master What can I do for you\nType /help to show all the Installed Commands.\nJoin @EVIL_X_BOT Channel for more Interesting Updates.");
            else sendmsg(update.getMessage().getChatId().toString(), "Hi "+getFirstName(update)+"\n@EvilX_bot on Fire.\nCommand me master What can I do for you\nType /help to show all the Installed Commands.");
        }
        if(cmd.equals("/promote"))
        {
            if(update.getMessage().getChat().isUserChat() == true) sendmsg(update.getMessage().getChatId().toString(),"Can't promote in UserChat\nUse This Command in Groups or Channels");
            else 
            {
                int id = update.getMessage().getFrom().getId();
                System.out.println(id+" "+update.getMessage().getFrom().getFirstName());
                User u = new User(id, update.getMessage().getFrom().getFirstName(), update.getMessage().getFrom().getIsBot());
                System.out.println(u.getId());
                SendMessage msg = new SendMessage(update.getMessage().getChatId().toString(),"Promoting "+update.getMessage().getReplyToMessage().getFrom().getFirstName()+"...");
                Message m = new Message();
                try {
                    m = execute(msg);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                int mid = m.getMessageId();
                EditMessageText emsg = new EditMessageText();
                emsg.setChatId(update.getMessage().getChatId().toString());
                emsg.setMessageId(mid);
                emsg.setText(update.getMessage().getReplyToMessage().getFrom().getFirstName()+" is Promoted Succesfully!!");
                promote(update.getMessage().getChatId().toString(), update.getMessage().getReplyToMessage().getFrom().getId());
                try {
                    execute(emsg);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        if(cmd.equals("/restart")||cmd.equals("/restart"+botextendedcmd))
        {
            stop = true;
            Message msg3 = new Message();
            try {
                msg3 = execute(new SendMessage(update.getMessage().getChatId().toString(), "Restarting @EvilX_bot ..."));
            } catch (TelegramApiException e5) {
                e5.printStackTrace();
            }
            //sendmsg(update.getMessage().getChatId().toString(), "Restarting @EvilX_bot ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e4) {
                sendmsg(update.getMessage().getChatId().toString(), "Error Occured!!");
                e4.printStackTrace();
            }
            SendMessage msg1 = new SendMessage(update.getMessage().getChatId().toString(), "Stopping All processes with Exit Code 0");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            Message delmsg = new Message();
            try {
                delmsg = execute(msg1);
            } catch (TelegramApiException e2) {
                sendmsg(update.getMessage().getChatId().toString(),"Error Occured");
                e2.printStackTrace();
            }
            DeleteMessage del = new DeleteMessage(update.getMessage().getChatId().toString(), delmsg.getMessageId());
            try {
                execute(del);
            } catch (TelegramApiException e2) {
                e2.printStackTrace();
            }

            SendMessage msg = new SendMessage(update.getMessage().getChatId().toString(), "Restarting @EvilX_bot ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            Message m = new Message();
            try {
                m = execute(msg);
            } catch (TelegramApiException e1) {
                sendmsg(update.getMessage().getChatId().toString(),"Error Occured");
                e1.printStackTrace();
            }
            String[] arr = {"Restarting All the Servers","Localhost state : up","Getting Restarted","@EvilX_bot restarted \nThanks to my Owner https://t.me/Hellion_OP"};
            for(int i = 0;i < 4;i++)
            {
                try {
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(update.getMessage().getChatId().toString());
                    editMessageText.setMessageId(m.getMessageId());
                    editMessageText.setText(arr[i]);
                    try {
                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    sendmsg(update.getMessage().getChatId().toString(), "Error Occured while Restarting The Bot.");
                    e.printStackTrace();
                }
            }
            DeleteMessage del2 = new DeleteMessage(update.getMessage().getChatId().toString(), msg3.getMessageId());
            try {
                execute(del2);
            } catch (TelegramApiException e2) {
                e2.printStackTrace();
            }
            stop = false;
        }
        if(cmd.equals("/spam")||cmd.equals("/spam"+botextendedcmd) && stop == false)
        {
            sendmsg(update.getMessage().getChatId().toString(), "Enter The number of messges to be sent");
        }
        if(cmd.equals("/bigspam")||cmd.equals("/bigspam"+botextendedcmd) && stop == false)
        {
            sendmsg(update.getMessage().getChatId().toString(), "Enter the number of messages for bigspam");
        }
        if(cmd.equals("/fastspam")||cmd.equals("/fastspam"+botextendedcmd) && stop == false)
        {
            sendmsg(update.getMessage().getChatId().toString(), "Enter the number of messages for fastspam");
        }
        if(cmd.equals("/help")||cmd.equals("/help"+botextendedcmd))
        {
            String[] arr = new String[5];
            arr[0] = "BOT/res/hacker.jpg";
            arr[1] = "BOT/res/nice.jpg";
            arr[2] = "BOT/res/idkhell.jpg";
            arr[3] = "BOT/res/cat.jpg";
            arr[4] = "BOT/res/AARYAN.jpg";
            int random = (int)(Math.random()*4);
            File file1 = new File(arr[random]);
            InputFile file = new InputFile(file1);
            SendPhoto photo = new SendPhoto(update.getMessage().getChatId().toString(), file);
            photo.setCaption("Thank you for Choosing EvilX Services\nHere we have Serveral Modules, basically EvilX is made to spam\nHere are some spam modules :\n1.Type /spam -> For normal Spam\n2.Type /bigspam -> to spam hard for more than 100 messages\n3.Type /fastspam -> The Deadly spam to spam any amount with great speed\n\nType /restart -> To Restart the Bot.");
            photo.setChatId(update.getMessage().getChatId().toString());
            try {
                execute(photo);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            sendmsg(update.getMessage().getChatId().toString(), "Contact owner https://t.me/Hellion_OP for more info :)");
        }
        if(cmd.equals("/getinvitelink"))
        {
            if(isinvitelinkset == false) sendmsg(update.getMessage().getChatId().toString(),"Please set your Invite link");
            else
            {
                System.out.println(link);
                sendmsg(update.getMessage().getChatId().toString(), link);
            }
        }
        if(cmd.equals("/setinvitelink"))
        {
            sendmsg(update.getMessage().getChatId().toString(),"Enter the invite link");
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the invite link"))
        {
            link = update.getMessage().getText().toString();
            update.getMessage().getChat().setInviteLink(link);
            isinvitelinkset = true;
            sendmsg(update.getMessage().getChatId().toString(), "Invite link set Successfully to : "+link);
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the number of messages for bigspam"))
        {
            spamno = Integer.parseInt(update.getMessage().getText());
            System.out.println(spamno);
            sendmsg(update.getMessage().getChatId().toString(),"Enter the message for bigspam");
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter The number of messges to be sent"))
        {
            spamno = Integer.parseInt(update.getMessage().getText());
            System.out.println(spamno);
            sendmsg(update.getMessage().getChatId().toString(),"Enter the message");
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the number of messages for fastspam"))
        {
            spamno = Integer.parseInt(update.getMessage().getText());
            System.out.println(spamno);
            sendmsg(update.getMessage().getChatId().toString(),"Enter the message for fastspam");
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the message"))
        {
            spamtext = update.getMessage().getText().toString();
            System.out.println(spamtext);
            spam(update, spamno, spamtext);
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the message for bigspam"))
        {
            spamtext = update.getMessage().getText().toString();
            System.out.println(spamtext);
            bigspam(update, spamno, spamtext);
        }
        if(update.getMessage().getReplyToMessage().getText().equals("Enter the message for fastspam"))
        {
            spamtext = update.getMessage().getText().toString();
            System.out.println(spamtext);
            fastspam(update, spamno, spamtext);
        }
    }
    public void promote(String chatId, int userId)
    {
        PromoteChatMember p = new PromoteChatMember(chatId, userId);
        try {
            execute(p);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void spam(Update update, int a, String text)
    {
        if(a <= 50)
        {
            for(int i = 0;i < a;i++)
            {
                sendmsg(update.getMessage().getChatId().toString(),text);
            }
        }
        else if(a > 50)
        {
            for(int i = 0;i < a;i++)
            {
                sendmsg(update.getMessage().getChatId().toString(),text);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(a >= 100)
        {
            sendmsg(update.getMessage().getChatId().toString(), "Use bigspam for more than 100 messages");
        }
    }

    public void bigspam(Update update, int a, String text)
    {
        for(int i = 0;i < a;i++)
        {
            sendmsg(update.getMessage().getChatId().toString(),text);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void fastspam(Update update, int a, String text)
    {
        for(int i = 0;i < a;i++)
        {
            sendmsg(update.getMessage().getChatId().toString(),text);
        }
    }

    public void sendmsg(String chatid, String text)
    {
        SendMessage msg = new SendMessage(chatid, text);
        msg.enableHtml(true);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName(Update update)
    {
        return update.getMessage().getFrom().getFirstName().toString();
    }

    public String getFullName(Update update)
    {
        return update.getMessage().getFrom().getFirstName().toString()+" "+
        update.getMessage().getFrom().getLastName().toString();
    }

    @Override
    public String getBotUsername() {
        return "EvilX_bot";
    }

    @Override
    public String getBotToken() {
        return "1720896575:AAGaOIruQmEh7uLbwQmcxrWZCHTU2xEJY3w";
    }
}
