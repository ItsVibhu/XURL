package com.crio.shorturl;
import java.util.HashMap;
import java.util.Random;
import java.lang.StringBuilder;
//Key=longUrl
//Value=shortUrl
public class XUrlImpl implements XUrl{
    HashMap<String,String> urlMap = new HashMap<>();
    HashMap<String,String> urlMap2 = new HashMap<>();
    public String registerNewUrl(String longUrl){
        if(urlMap.containsKey(longUrl)){
            return urlMap.get(longUrl);
        }
        else{
            Random rand = new Random();
            int urlLen = 9;
            char [] shortURL = new char[urlLen];
            String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

            for(int i = 0; i < urlLen; i++ )
                shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

            StringBuilder sb = new StringBuilder("http://short.url/");
            sb.append(new String(shortURL));
            System.out.println(sb);

            urlMap.put(longUrl,sb.toString());
            urlMap2.put(sb.toString(),longUrl);

            return sb.toString();
        }

    }
    public String registerNewUrl(String longUrl, String shortUrl){
        if(urlMap.containsValue(shortUrl))
        return null;
        else
        urlMap.put(longUrl,shortUrl);
        urlMap2.put(shortUrl,longUrl);
        return shortUrl;
    }
    public String getUrl(String shortUrl){
        if(urlMap.containsValue(shortUrl)){
        String url = urlMap2.get(shortUrl);
        getHitCount(url);
        return url;
        }
        else
        return null;
    }
    public String delete(String longUrl){
        String url=urlMap.get(longUrl);
        urlMap.remove(longUrl);
        urlMap2.remove(url);
        return null;
    }
    public Integer getHitCount(String longUrl){
        int count=0;
        count++;
        System.out.println(count);
        return count;
    }
}