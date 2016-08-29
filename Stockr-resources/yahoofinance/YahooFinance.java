/*   1:    */ package yahoofinance;
/*   2:    */ 
/*   3:    */ import java.util.Calendar;
/*   4:    */ import java.util.HashMap;
/*   5:    */ import java.util.List;
/*   6:    */ import java.util.Map;
/*   7:    */ import java.util.logging.Logger;
/*   8:    */ import yahoofinance.histquotes.HistQuotesRequest;
/*   9:    */ import yahoofinance.histquotes.Interval;
/*  10:    */ import yahoofinance.quotes.fx.FxQuote;
/*  11:    */ import yahoofinance.quotes.fx.FxQuotesRequest;
/*  12:    */ import yahoofinance.quotes.stock.StockQuotesData;
/*  13:    */ import yahoofinance.quotes.stock.StockQuotesRequest;
/*  14:    */ 
/*  15:    */ public class YahooFinance
/*  16:    */ {
/*  17:    */   public static final String QUOTES_BASE_URL = "http://finance.yahoo.com/d/quotes.csv";
/*  18:    */   public static final String HISTQUOTES_BASE_URL = "http://ichart.yahoo.com/table.csv";
/*  19:    */   public static final String QUOTES_CSV_DELIMITER = ",";
/*  20:    */   public static final String TIMEZONE = "America/New_York";
/*  21: 48 */   public static final Logger logger = Logger.getLogger(YahooFinance.class.getName());
/*  22:    */   
/*  23:    */   public static Stock get(String symbol)
/*  24:    */   {
/*  25: 61 */     return get(symbol, false);
/*  26:    */   }
/*  27:    */   
/*  28:    */   public static Stock get(String symbol, boolean includeHistorical)
/*  29:    */   {
/*  30: 76 */     Map<String, Stock> result = getQuotes(symbol, includeHistorical);
/*  31: 77 */     return (Stock)result.get(symbol);
/*  32:    */   }
/*  33:    */   
/*  34:    */   public static Stock get(String symbol, Interval interval)
/*  35:    */   {
/*  36: 90 */     return get(symbol, HistQuotesRequest.DEFAULT_FROM, HistQuotesRequest.DEFAULT_TO, interval);
/*  37:    */   }
/*  38:    */   
/*  39:    */   public static Stock get(String symbol, Calendar from)
/*  40:    */   {
/*  41:104 */     return get(symbol, from, HistQuotesRequest.DEFAULT_TO, HistQuotesRequest.DEFAULT_INTERVAL);
/*  42:    */   }
/*  43:    */   
/*  44:    */   public static Stock get(String symbol, Calendar from, Interval interval)
/*  45:    */   {
/*  46:119 */     return get(symbol, from, HistQuotesRequest.DEFAULT_TO, interval);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public static Stock get(String symbol, Calendar from, Calendar to)
/*  50:    */   {
/*  51:135 */     return get(symbol, from, to, HistQuotesRequest.DEFAULT_INTERVAL);
/*  52:    */   }
/*  53:    */   
/*  54:    */   public static Stock get(String symbol, Calendar from, Calendar to, Interval interval)
/*  55:    */   {
/*  56:152 */     Map<String, Stock> result = getQuotes(symbol, from, to, interval);
/*  57:153 */     return (Stock)result.get(symbol);
/*  58:    */   }
/*  59:    */   
/*  60:    */   public static Map<String, Stock> get(String[] symbols)
/*  61:    */   {
/*  62:171 */     return get(symbols, false);
/*  63:    */   }
/*  64:    */   
/*  65:    */   public static Map<String, Stock> get(String[] symbols, boolean includeHistorical)
/*  66:    */   {
/*  67:191 */     return getQuotes(Utils.join(symbols, ","), includeHistorical);
/*  68:    */   }
/*  69:    */   
/*  70:    */   public static Map<String, Stock> get(String[] symbols, Interval interval)
/*  71:    */   {
/*  72:209 */     return getQuotes(Utils.join(symbols, ","), HistQuotesRequest.DEFAULT_FROM, HistQuotesRequest.DEFAULT_TO, interval);
/*  73:    */   }
/*  74:    */   
/*  75:    */   public static Map<String, Stock> get(String[] symbols, Calendar from)
/*  76:    */   {
/*  77:227 */     return getQuotes(Utils.join(symbols, ","), from, HistQuotesRequest.DEFAULT_TO, HistQuotesRequest.DEFAULT_INTERVAL);
/*  78:    */   }
/*  79:    */   
/*  80:    */   public static Map<String, Stock> get(String[] symbols, Calendar from, Interval interval)
/*  81:    */   {
/*  82:246 */     return getQuotes(Utils.join(symbols, ","), from, HistQuotesRequest.DEFAULT_TO, interval);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public static Map<String, Stock> get(String[] symbols, Calendar from, Calendar to)
/*  86:    */   {
/*  87:266 */     return getQuotes(Utils.join(symbols, ","), from, to, HistQuotesRequest.DEFAULT_INTERVAL);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public static Map<String, Stock> get(String[] symbols, Calendar from, Calendar to, Interval interval)
/*  91:    */   {
/*  92:287 */     return getQuotes(Utils.join(symbols, ","), from, to, interval);
/*  93:    */   }
/*  94:    */   
/*  95:    */   public static FxQuote getFx(String symbol)
/*  96:    */   {
/*  97:306 */     FxQuotesRequest request = new FxQuotesRequest(symbol);
/*  98:307 */     return (FxQuote)request.getSingleResult();
/*  99:    */   }
/* 100:    */   
/* 101:    */   public static Map<String, FxQuote> getFx(String[] symbols)
/* 102:    */   {
/* 103:321 */     FxQuotesRequest request = new FxQuotesRequest(Utils.join(symbols, ","));
/* 104:322 */     List<FxQuote> quotes = request.getResult();
/* 105:323 */     Map<String, FxQuote> result = new HashMap();
/* 106:324 */     for (FxQuote quote : quotes) {
/* 107:325 */       result.put(quote.getSymbol(), quote);
/* 108:    */     }
/* 109:327 */     return result;
/* 110:    */   }
/* 111:    */   
/* 112:    */   private static Map<String, Stock> getQuotes(String query, boolean includeHistorical)
/* 113:    */   {
/* 114:331 */     StockQuotesRequest request = new StockQuotesRequest(query);
/* 115:332 */     List<StockQuotesData> quotes = request.getResult();
/* 116:333 */     Map<String, Stock> result = new HashMap();
/* 117:335 */     for (StockQuotesData data : quotes)
/* 118:    */     {
/* 119:336 */       Stock s = data.getStock();
/* 120:337 */       result.put(s.getSymbol(), s);
/* 121:    */     }
/* 122:340 */     if (includeHistorical) {
/* 123:341 */       for (Stock s : result.values()) {
/* 124:342 */         s.getHistory();
/* 125:    */       }
/* 126:    */     }
/* 127:346 */     return result;
/* 128:    */   }
/* 129:    */   
/* 130:    */   private static Map<String, Stock> getQuotes(String query, Calendar from, Calendar to, Interval interval)
/* 131:    */   {
/* 132:350 */     Map<String, Stock> stocks = getQuotes(query, false);
/* 133:351 */     stocks = fetchHistoricalQuotes(stocks, from, to, interval);
/* 134:352 */     return stocks;
/* 135:    */   }
/* 136:    */   
/* 137:    */   private static Map<String, Stock> fetchHistoricalQuotes(Map<String, Stock> stocks, Calendar from, Calendar to, Interval interval)
/* 138:    */   {
/* 139:356 */     for (Stock s : stocks.values()) {
/* 140:357 */       s.getHistory(from, to, interval);
/* 141:    */     }
/* 142:359 */     return stocks;
/* 143:    */   }
/* 144:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.YahooFinance
 * JD-Core Version:    0.7.0.1
 */