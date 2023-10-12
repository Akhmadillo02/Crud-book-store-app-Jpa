package uz.najottalim.jpapractise;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) {
        String url = "https://www.w3schools.com/html/mov_bbb.mp4";
        String fileName = "src/service/video";

        FileOutputStream fout = null;
        BufferedInputStream in = null;

        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count ;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
                fout.flush();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
