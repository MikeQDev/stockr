/*   1:    */ package yahoofinance.quotes;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.InputStreamReader;
/*   6:    */ import java.net.URL;
/*   7:    */ import java.net.URLConnection;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ import java.util.LinkedHashMap;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Map;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ import yahoofinance.Utils;
/*  15:    */ import yahoofinance.YahooFinance;
/*  16:    */ 
/*  17:    */ public abstract class QuotesRequest<T>
/*  18:    */ {
/*  19:    */   protected final String query;
/*  20:    */   protected List<QuotesProperty> properties;
/*  21:    */   
/*  22:    */   public QuotesRequest(String query, List<QuotesProperty> properties)
/*  23:    */   {
/*  24: 28 */     this.query = query;
/*  25: 29 */     this.properties = properties;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getQuery()
/*  29:    */   {
/*  30: 33 */     return this.query;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public List<QuotesProperty> getProperties()
/*  34:    */   {
/*  35: 37 */     return this.properties;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setProperties(List<QuotesProperty> properties)
/*  39:    */   {
/*  40: 41 */     this.properties = properties;
/*  41:    */   }
/*  42:    */   
/*  43:    */   protected abstract T parseCSVLine(String paramString);
/*  44:    */   
/*  45:    */   private String getFieldsString()
/*  46:    */   {
/*  47: 47 */     StringBuilder result = new StringBuilder();
/*  48: 48 */     for (QuotesProperty property : this.properties) {
/*  49: 49 */       result.append(property.getTag());
/*  50:    */     }
/*  51: 51 */     return result.toString();
/*  52:    */   }
/*  53:    */   
/*  54:    */   public T getSingleResult()
/*  55:    */   {
/*  56: 55 */     List<T> results = getResult();
/*  57: 56 */     if (results.size() > 0) {
/*  58: 57 */       return results.get(0);
/*  59:    */     }
/*  60: 59 */     return null;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public List<T> getResult()
/*  64:    */   {
/*  65: 68 */     List<T> result = new ArrayList();
/*  66:    */     try
/*  67:    */     {
/*  68: 71 */       Map<String, String> params = new LinkedHashMap();
/*  69: 72 */       params.put("s", this.query);
/*  70: 73 */       params.put("f", getFieldsString());
/*  71: 74 */       params.put("e", ".csv");
/*  72:    */       
/*  73: 76 */       String url = "http://finance.yahoo.com/d/quotes.csv?" + Utils.getURLParameters(params);
/*  74:    */       
/*  75:    */ 
/*  76: 79 */       YahooFinance.logger.log(Level.INFO, "Sending request: " + url);
/*  77:    */       
/*  78: 81 */       URL request = new URL(url);
/*  79: 82 */       URLConnection connection = request.openConnection();
/*  80: 83 */       InputStreamReader is = new InputStreamReader(connection.getInputStream());
/*  81: 84 */       BufferedReader br = new BufferedReader(is);
/*  82: 87 */       for (String line = br.readLine(); line != null; line = br.readLine()) {
/*  83: 88 */         if (line.equals("Missing Symbols List."))
/*  84:    */         {
/*  85: 89 */           YahooFinance.logger.log(Level.SEVERE, "The requested symbol was not recognized by Yahoo Finance");
/*  86:    */         }
/*  87:    */         else
/*  88:    */         {
/*  89: 91 */           YahooFinance.logger.log(Level.INFO, "Parsing CSV line: " + Utils.unescape(line));
/*  90:    */           
/*  91: 93 */           T data = parseCSVLine(line);
/*  92: 94 */           result.add(data);
/*  93:    */         }
/*  94:    */       }
/*  95:    */     }
/*  96:    */     catch (IOException ex)
/*  97:    */     {
/*  98: 98 */       YahooFinance.logger.log(Level.SEVERE, ex.toString(), ex);
/*  99:    */     }
/* 100:101 */     return result;
/* 101:    */   }
/* 102:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.QuotesRequest
 * JD-Core Version:    0.7.0.1
 */