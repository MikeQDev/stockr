/*   1:    */ package yahoofinance.histquotes;
/*   2:    */ 
/*   3:    */ import java.io.BufferedReader;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.InputStreamReader;
/*   6:    */ import java.net.URL;
/*   7:    */ import java.net.URLConnection;
/*   8:    */ import java.util.ArrayList;
/*   9:    */ import java.util.Calendar;
/*  10:    */ import java.util.Date;
/*  11:    */ import java.util.LinkedHashMap;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.Map;
/*  14:    */ import java.util.logging.Level;
/*  15:    */ import java.util.logging.Logger;
/*  16:    */ import yahoofinance.Utils;
/*  17:    */ import yahoofinance.YahooFinance;
/*  18:    */ 
/*  19:    */ public class HistQuotesRequest
/*  20:    */ {
/*  21:    */   private final String symbol;
/*  22:    */   private final Calendar from;
/*  23:    */   private final Calendar to;
/*  24:    */   private final Interval interval;
/*  25: 32 */   public static final Calendar DEFAULT_FROM = ;
/*  26:    */   
/*  27:    */   static
/*  28:    */   {
/*  29: 34 */     DEFAULT_FROM.add(1, -1);
/*  30:    */   }
/*  31:    */   
/*  32: 36 */   public static final Calendar DEFAULT_TO = Calendar.getInstance();
/*  33: 37 */   public static final Interval DEFAULT_INTERVAL = Interval.MONTHLY;
/*  34:    */   
/*  35:    */   public HistQuotesRequest(String symbol)
/*  36:    */   {
/*  37: 40 */     this(symbol, DEFAULT_INTERVAL);
/*  38:    */   }
/*  39:    */   
/*  40:    */   public HistQuotesRequest(String symbol, Interval interval)
/*  41:    */   {
/*  42: 44 */     this.symbol = symbol;
/*  43: 45 */     this.interval = interval;
/*  44:    */     
/*  45: 47 */     this.from = DEFAULT_FROM;
/*  46: 48 */     this.to = DEFAULT_TO;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public HistQuotesRequest(String symbol, Calendar from, Calendar to)
/*  50:    */   {
/*  51: 52 */     this(symbol, from, to, DEFAULT_INTERVAL);
/*  52:    */   }
/*  53:    */   
/*  54:    */   public HistQuotesRequest(String symbol, Calendar from, Calendar to, Interval interval)
/*  55:    */   {
/*  56: 56 */     this.symbol = symbol;
/*  57: 57 */     this.from = from;
/*  58: 58 */     this.to = to;
/*  59: 59 */     this.interval = interval;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public HistQuotesRequest(String symbol, Date from, Date to)
/*  63:    */   {
/*  64: 63 */     this(symbol, from, to, DEFAULT_INTERVAL);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public HistQuotesRequest(String symbol, Date from, Date to, Interval interval)
/*  68:    */   {
/*  69: 67 */     this(symbol, interval);
/*  70: 68 */     this.from.setTime(from);
/*  71: 69 */     this.to.setTime(to);
/*  72:    */   }
/*  73:    */   
/*  74:    */   public List<HistoricalQuote> getResult()
/*  75:    */   {
/*  76: 74 */     List<HistoricalQuote> result = new ArrayList();
/*  77:    */     try
/*  78:    */     {
/*  79: 77 */       Map<String, String> params = new LinkedHashMap();
/*  80: 78 */       params.put("s", this.symbol);
/*  81:    */       
/*  82: 80 */       params.put("a", String.valueOf(this.from.get(2)));
/*  83: 81 */       params.put("b", String.valueOf(this.from.get(5)));
/*  84: 82 */       params.put("c", String.valueOf(this.from.get(1)));
/*  85:    */       
/*  86: 84 */       params.put("d", String.valueOf(this.to.get(2)));
/*  87: 85 */       params.put("e", String.valueOf(this.to.get(5)));
/*  88: 86 */       params.put("f", String.valueOf(this.to.get(1)));
/*  89:    */       
/*  90: 88 */       params.put("g", this.interval.getTag());
/*  91:    */       
/*  92: 90 */       params.put("ignore", ".csv");
/*  93:    */       
/*  94: 92 */       String url = "http://ichart.yahoo.com/table.csv?" + Utils.getURLParameters(params);
/*  95:    */       
/*  96:    */ 
/*  97: 95 */       YahooFinance.logger.log(Level.INFO, "Sending request: " + url);
/*  98:    */       
/*  99: 97 */       URL request = new URL(url);
/* 100: 98 */       URLConnection connection = request.openConnection();
/* 101: 99 */       InputStreamReader is = new InputStreamReader(connection.getInputStream());
/* 102:100 */       BufferedReader br = new BufferedReader(is);
/* 103:101 */       br.readLine();
/* 104:103 */       for (String line = br.readLine(); line != null; line = br.readLine())
/* 105:    */       {
/* 106:105 */         YahooFinance.logger.log(Level.INFO, "Parsing CSV line: " + Utils.unescape(line));
/* 107:106 */         HistoricalQuote quote = parseCSVLine(line);
/* 108:107 */         result.add(quote);
/* 109:    */       }
/* 110:    */     }
/* 111:    */     catch (IOException ex)
/* 112:    */     {
/* 113:110 */       YahooFinance.logger.log(Level.SEVERE, ex.toString(), ex);
/* 114:    */     }
/* 115:112 */     return result;
/* 116:    */   }
/* 117:    */   
/* 118:    */   private HistoricalQuote parseCSVLine(String line)
/* 119:    */   {
/* 120:116 */     String[] data = line.split(",");
/* 121:    */     
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:124 */     return new HistoricalQuote(this.symbol, Utils.parseHistDate(data[0]), Utils.getBigDecimal(data[1]), Utils.getBigDecimal(data[3]), Utils.getBigDecimal(data[2]), Utils.getBigDecimal(data[4]), Utils.getBigDecimal(data[6]), Utils.getLong(data[5]));
/* 129:    */   }
/* 130:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.histquotes.HistQuotesRequest
 * JD-Core Version:    0.7.0.1
 */