import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.IOException;
 import java.util.Iterator;

import org.jsoup.Jsoup;
 import org.jsoup.nodes.Document;
 import org.jsoup.nodes.Element;
 import org.jsoup.select.Elements;

public class WeatherInfo 
{
 public static void main(String[] args) throws Exception 
{
 String getUrl = "http://www.weather.com.cn/weather1d/101200801.shtml";
 
Document doc = Jsoup.connect(getUrl).timeout(5000).get();
 Element body = doc.body();
 Elements el=body.select("div[class=today clearfix]");
 
 Iterator it = el.iterator();
 String[]s=new String[100];

 int i=0;
 while( it .hasNext() ) {
	    Element e = (Element) it.next();
	    s[i]=e.text();
	    System.out.println(s[i]);
	    i++;
	}

}

}


//第二种写法
//import java.io.IOException;  
//  
//import org.jsoup.*;  
//import org.jsoup.helper.Validate;  
//import org.jsoup.nodes.Document;  
//import org.jsoup.nodes.Element;  
//import org.jsoup.select.Elements;  
//  
//public class WeatherInfo {  
//    public static  void main(String[] args) throws IOException{  
//    String url = "http://www.weather.com.cn/weather1d/101200801.shtml"; 
//  
//    long start = System.currentTimeMillis();  
//    Document doc=null;  
//    try{  
//        doc = Jsoup.connect(url).timeout(5000).get();
//
//    }  
//    catch(Exception e){  
//        e.printStackTrace();  
//    }  
//    finally{  
//        System.out.println("Time is:"+(System.currentTimeMillis()-start) + "ms");  
//    }  
//    Elements elem = doc.getElementsByTag("Title");
//    Elements elem1 = doc.select("div[class=today clearfix]");
//    System.out.println("Title is:" +elem.text());  
//    System.out.println("Weather is:" +elem1.text());
//    }     
//}  