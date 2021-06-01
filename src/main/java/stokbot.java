import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class stokbot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "stockrep_bot";
    }

    @Override
    public String getBotToken() {
        return "1699227524:AAGBQPsPaj-0VWBOg9EbjNOzUVzZVpeu_IQ";
    }

    @Override
    public void onUpdateReceived(Update update) {


        String commands = update.getMessage().getText();
        SendMessage message= new SendMessage();
        switch(commands) {
            case "/start":
                message.setText("Hai Selamat Datang, Bot ini dibuat untuk project Tugas Akhir Matkul Pemrogramman 1 " +
                        "\n\nNama Saya Eko Budiarto, dari Universitas Pamulang " +
                        "\n\nIni adalah bot cek stok barang" +
                        "\n\nBot ini akan aktif dari tanggal 01-06-2021 sampai 06-06-2021 jam 08.00-21.00" +
                        "\n\nApabila bot ini mati silahkan hubungi nmr berikut 082322728715 telp/WA ");
                break;
            case "/menu":
                message.setText("Menu\n" +
                        "\n1. Tampilkan Semua Produk /tampilkan_produk " +
                        "\n2. Cari Produk /search_produc" +
                        "\n3. Tentang pembuat /tentang_saya "+
                        "\n5. ");
                break;
            case "/tentang_saya":
                message.setText("TENTANG SAYA\n" +
                        "\nHai, Nama Saya Eko Budiarto, Saya adalah Mahasiswa sekaligus Freelance Developer. " +
                        "\n\nContact Me  " +
                        "\nLinkedln : bit.ly/3eVTnvd " +
                        "\nEmail      : ekobcode@gmail.com " +
                        "\nWA          : 082322728715 " +
                        "\nGithub    : bit.ly/3gZJZsZ ");
                break;
            case "/tampilkan_produk":
                File file = new File("C:\\database.txt");
                Scanner input = null;
                try {
                    input = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (input.hasNextLine()){
                    String line = input.nextLine();
                    message.setText(line);
                }
                input.close();
                break;
            case "/cari_produk":
                message.setText("Menampilkan Semua Data\n\n");

                break;
            //case "/kondisi":
            //      masukan kode dibawah ini
            //    break;
            default:
               message.setText("Maaf saya tidak mengerti :(");
        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        try{
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }


}
