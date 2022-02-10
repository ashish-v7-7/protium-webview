package com.protium.protiumwebviewapp2;

import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String BASE_URL = "https://web-consumer.protium.net.in/?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHBsaWNhdGlvbl9pZCI6IjY4ODk4MzE4NDU5MjQ1NzMxODQifQ.Pl_3RWrUIhRHkh_0GFZUPuFjUVzclkhO1ahHcDVuf9w&stage=nach";
    WebView myWebView, myWebView3;
    RelativeLayout parentLayout;
    boolean isAccepted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.web_view);
        parentLayout = findViewById(R.id.parent_layout);

        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setAllowFileAccess(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        myWebView.getSettings().getCacheMode();
        myWebView.getSettings().setSupportMultipleWindows(true);

        myWebView.setWebViewClient(new BrowserClient());
        myWebView.setWebChromeClient(new BrowserChromeClient());

        myWebView.loadUrl(BASE_URL);

    }

    private class BrowserClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(String.valueOf(request.getUrl()));
//            Log.e("sss",request.getUrl().toString());
//            String url =String.valueOf(request.getUrl());
//            String search  = "is_success=true";
//            isAccepted = url.toLowerCase().contains(search.toLowerCase());
            return false;
        }
    }

    private class BrowserChromeClient extends WebChromeClient {
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {

            //create runtime webView
            WebView myWebView2 = new WebView(MainActivity.this);
            myWebView2.getSettings().setLoadWithOverviewMode(true);
            myWebView2.getSettings().setUseWideViewPort(true);
            myWebView2.getSettings().setAllowFileAccess(true);
            myWebView2.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            myWebView2.getSettings().setDomStorageEnabled(true);
            myWebView2.getSettings().setJavaScriptEnabled(true);
            myWebView2.getSettings().setAllowFileAccessFromFileURLs(true);
            myWebView2.getSettings().setAllowUniversalAccessFromFileURLs(true);
            myWebView2.getSettings().getCacheMode();
            myWebView2.getSettings().setSupportMultipleWindows(true);

            myWebView2.setWebViewClient(new BrowserClient());
            myWebView2.setWebChromeClient(new BrowserChromeClient());

            myWebView2.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            parentLayout.addView(myWebView2);

            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(myWebView2);
            resultMsg.sendToTarget();
            return true;
        }
        @Override
        public void onCloseWindow(WebView window) {
            super.onCloseWindow(window);
            parentLayout.removeView(window);
            window.destroy();
        }
    }
}

































//private class BrowserChromeClient2 extends WebChromeClient {
//    @Override
//    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
//        //create runtime webview
//        myWebView3 = new WebView(MainActivity.this);
//        myWebView3.getSettings().setLoadWithOverviewMode(true);
//        myWebView3.getSettings().setUseWideViewPort(true);
//        myWebView3.getSettings().setAllowFileAccess(true);
//        myWebView3.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        myWebView3.getSettings().setDomStorageEnabled(true);
//        myWebView3.getSettings().setJavaScriptEnabled(true);
//        myWebView3.getSettings().setAllowFileAccessFromFileURLs(true);
//        myWebView3.getSettings().setAllowUniversalAccessFromFileURLs(true);
//        myWebView3.getSettings().getCacheMode();
//        myWebView3.getSettings().setSupportMultipleWindows(true);
//
//        myWebView3.setWebViewClient(new BrowserClient3());
//        myWebView3.setWebChromeClient(new BrowserChromeClient3());
//
//        myWebView3.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        parentLayout.addView(myWebView3);
//
//        WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
//        transport.setWebView(myWebView3);
//        resultMsg.sendToTarget();
//        return true;
//
//    }
//
//    @Override
//    public void onCloseWindow(WebView window) {
//        super.onCloseWindow(window);
//
//        try {
//            parentLayout.removeView(myWebView2);
//            myWebView2.destroy();
//            myWebView.setFocusable(true);
//        }catch (Exception ignored){
//
//        }
//
//    }
//}
//
//private class BrowserClient2 extends WebViewClient {
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//        view.loadUrl(String.valueOf(request.getUrl()));
//        return super.shouldOverrideUrlLoading(view, request);
//    }
//}
//
//
//private class BrowserChromeClient3 extends WebChromeClient {
//
//    @Override
//    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
//        //create runtime webview
//
//        myWebView3 = new WebView(MainActivity.this);
//        myWebView3.getSettings().setLoadWithOverviewMode(true);
//        myWebView3.getSettings().setUseWideViewPort(true);
//        myWebView3.getSettings().setAllowFileAccess(true);
//        myWebView3.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        myWebView3.getSettings().setDomStorageEnabled(true);
//        myWebView3.getSettings().setJavaScriptEnabled(true);
//        myWebView3.getSettings().setAllowFileAccessFromFileURLs(true);
//        myWebView3.getSettings().setAllowUniversalAccessFromFileURLs(true);
//        myWebView3.getSettings().getCacheMode();
//        myWebView3.getSettings().setSupportMultipleWindows(true);
//
//        myWebView3.setWebViewClient(new BrowserClient3());
//        myWebView3.setWebChromeClient(new BrowserChromeClient3());
//
//        myWebView3.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        parentLayout.addView(myWebView3);
//
//        WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
//        transport.setWebView(myWebView3);
//        resultMsg.sendToTarget();
//        return true;
//    }
//
//
//    @Override
//    public void onCloseWindow(WebView window) {
//        super.onCloseWindow(window);
//        if (isAccepted){
//            parentLayout.removeView(myWebView3);
//            myWebView3.destroy();
//            myWebView2.setFocusable(true);
//        }else {
//            parentLayout.removeView(myWebView3);
//            myWebView3.destroy();
//            myWebView2.setFocusable(true);
//            parentLayout.removeView(myWebView2);
//            myWebView2.destroy();
//            myWebView.setFocusable(true);
//        }
//
//
//    }
//}
//
//private class BrowserClient3 extends WebViewClient {
//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//        view.loadUrl(String.valueOf(request.getUrl()));
//
//        String url =String.valueOf(request.getUrl());
//        String search  = "is_success=true";
//        isAccepted = url.toLowerCase().contains(search.toLowerCase());
//        return super.shouldOverrideUrlLoading(view, request);
//
//    }
//}