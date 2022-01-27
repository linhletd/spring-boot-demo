package com.example.demo.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
  private final String SITE_IS_UP = "Site is up!";
  private final String SITE_IS_DOWN = "Site is down!";
  private final String INCORRECT_URL = "Incorrect url";

  @GetMapping("/check")
  public String getUrlStatusMessage(@RequestParam String url){
    String returnUrlMessage = "";
    try {
      URL urlObj = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
      conn.setRequestMethod("GET");
      int responseCode = conn.getResponseCode()/100;
      if(responseCode == 2 || responseCode == 3){
        returnUrlMessage = SITE_IS_UP;
      }
      else {
        returnUrlMessage = SITE_IS_DOWN;
      }
    } catch (MalformedURLException e) {
      returnUrlMessage = INCORRECT_URL;
      e.printStackTrace();
    }
    catch(IOException e){
      returnUrlMessage = SITE_IS_DOWN;
    }
    
    return returnUrlMessage;
  }
  
}
