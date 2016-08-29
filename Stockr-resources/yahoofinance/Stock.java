/*   1:    */ package yahoofinance;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.lang.reflect.Field;
/*   5:    */ import java.util.Calendar;
/*   6:    */ import java.util.List;
/*   7:    */ import java.util.logging.Level;
/*   8:    */ import java.util.logging.Logger;
/*   9:    */ import yahoofinance.histquotes.HistQuotesRequest;
/*  10:    */ import yahoofinance.histquotes.HistoricalQuote;
/*  11:    */ import yahoofinance.histquotes.Interval;
/*  12:    */ import yahoofinance.quotes.stock.StockDividend;
/*  13:    */ import yahoofinance.quotes.stock.StockQuote;
/*  14:    */ import yahoofinance.quotes.stock.StockQuotesData;
/*  15:    */ import yahoofinance.quotes.stock.StockQuotesRequest;
/*  16:    */ import yahoofinance.quotes.stock.StockStats;
/*  17:    */ 
/*  18:    */ public class Stock
/*  19:    */ {
/*  20:    */   private final String symbol;
/*  21:    */   private String name;
/*  22:    */   private String currency;
/*  23:    */   private String stockExchange;
/*  24:    */   private StockQuote quote;
/*  25:    */   private StockStats stats;
/*  26:    */   private StockDividend dividend;
/*  27:    */   private List<HistoricalQuote> history;
/*  28:    */   
/*  29:    */   public Stock(String symbol)
/*  30:    */   {
/*  31: 35 */     this.symbol = symbol;
/*  32:    */   }
/*  33:    */   
/*  34:    */   private void update()
/*  35:    */   {
/*  36: 39 */     StockQuotesRequest request = new StockQuotesRequest(this.symbol);
/*  37: 40 */     StockQuotesData data = (StockQuotesData)request.getSingleResult();
/*  38: 41 */     if (data != null)
/*  39:    */     {
/*  40: 42 */       setQuote(data.getQuote());
/*  41: 43 */       setStats(data.getStats());
/*  42: 44 */       setDividend(data.getDividend());
/*  43: 45 */       YahooFinance.logger.log(Level.INFO, "Updated Stock with symbol: {0}", this.symbol);
/*  44:    */     }
/*  45:    */     else
/*  46:    */     {
/*  47: 47 */       YahooFinance.logger.log(Level.SEVERE, "Failed to update Stock with symbol: {0}", this.symbol);
/*  48:    */     }
/*  49:    */   }
/*  50:    */   
/*  51:    */   public StockQuote getQuote()
/*  52:    */   {
/*  53: 59 */     if (this.quote != null) {
/*  54: 60 */       return this.quote;
/*  55:    */     }
/*  56: 62 */     return getQuote(true);
/*  57:    */   }
/*  58:    */   
/*  59:    */   public StockQuote getQuote(boolean refresh)
/*  60:    */   {
/*  61: 83 */     if (refresh) {
/*  62: 84 */       update();
/*  63:    */     }
/*  64: 86 */     return this.quote;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setQuote(StockQuote quote)
/*  68:    */   {
/*  69: 90 */     this.quote = quote;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public StockStats getStats()
/*  73:    */   {
/*  74:101 */     if (this.stats != null) {
/*  75:102 */       return this.stats;
/*  76:    */     }
/*  77:104 */     return getStats(true);
/*  78:    */   }
/*  79:    */   
/*  80:    */   public StockStats getStats(boolean refresh)
/*  81:    */   {
/*  82:125 */     if (refresh) {
/*  83:126 */       update();
/*  84:    */     }
/*  85:128 */     return this.stats;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setStats(StockStats stats)
/*  89:    */   {
/*  90:132 */     this.stats = stats;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public StockDividend getDividend()
/*  94:    */   {
/*  95:143 */     if (this.dividend != null) {
/*  96:144 */       return this.dividend;
/*  97:    */     }
/*  98:146 */     return getDividend(true);
/*  99:    */   }
/* 100:    */   
/* 101:    */   public StockDividend getDividend(boolean refresh)
/* 102:    */   {
/* 103:168 */     if (refresh) {
/* 104:169 */       update();
/* 105:    */     }
/* 106:171 */     return this.dividend;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setDividend(StockDividend dividend)
/* 110:    */   {
/* 111:175 */     this.dividend = dividend;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public List<HistoricalQuote> getHistory()
/* 115:    */   {
/* 116:204 */     if (this.history != null) {
/* 117:205 */       return this.history;
/* 118:    */     }
/* 119:207 */     return getHistory(HistQuotesRequest.DEFAULT_FROM);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public List<HistoricalQuote> getHistory(Interval interval)
/* 123:    */   {
/* 124:223 */     return getHistory(HistQuotesRequest.DEFAULT_FROM, interval);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public List<HistoricalQuote> getHistory(Calendar from)
/* 128:    */   {
/* 129:239 */     return getHistory(from, HistQuotesRequest.DEFAULT_TO);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public List<HistoricalQuote> getHistory(Calendar from, Interval interval)
/* 133:    */   {
/* 134:256 */     return getHistory(from, HistQuotesRequest.DEFAULT_TO, interval);
/* 135:    */   }
/* 136:    */   
/* 137:    */   public List<HistoricalQuote> getHistory(Calendar from, Calendar to)
/* 138:    */   {
/* 139:273 */     return getHistory(from, to, Interval.MONTHLY);
/* 140:    */   }
/* 141:    */   
/* 142:    */   public List<HistoricalQuote> getHistory(Calendar from, Calendar to, Interval interval)
/* 143:    */   {
/* 144:291 */     HistQuotesRequest hist = new HistQuotesRequest(this.symbol, from, to, interval);
/* 145:292 */     setHistory(hist.getResult());
/* 146:293 */     return this.history;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setHistory(List<HistoricalQuote> history)
/* 150:    */   {
/* 151:297 */     this.history = history;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public String getSymbol()
/* 155:    */   {
/* 156:301 */     return this.symbol;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public String getName()
/* 160:    */   {
/* 161:305 */     return this.name;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setName(String name)
/* 165:    */   {
/* 166:309 */     this.name = name;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public String getCurrency()
/* 170:    */   {
/* 171:313 */     return this.currency;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setCurrency(String currency)
/* 175:    */   {
/* 176:317 */     this.currency = currency;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public String getStockExchange()
/* 180:    */   {
/* 181:321 */     return this.stockExchange;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setStockExchange(String stockExchange)
/* 185:    */   {
/* 186:325 */     this.stockExchange = stockExchange;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public String toString()
/* 190:    */   {
/* 191:330 */     return this.symbol + ": " + this.quote.getPrice();
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void print()
/* 195:    */   {
/* 196:334 */     System.out.println(this.symbol);
/* 197:335 */     System.out.println("--------------------------------");
/* 198:336 */     for (Field f : getClass().getDeclaredFields()) {
/* 199:    */       try
/* 200:    */       {
/* 201:338 */         System.out.println(f.getName() + ": " + f.get(this));
/* 202:    */       }
/* 203:    */       catch (IllegalArgumentException ex)
/* 204:    */       {
/* 205:340 */         Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
/* 206:    */       }
/* 207:    */       catch (IllegalAccessException ex)
/* 208:    */       {
/* 209:342 */         Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
/* 210:    */       }
/* 211:    */     }
/* 212:345 */     System.out.println("--------------------------------");
/* 213:    */   }
/* 214:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.Stock
 * JD-Core Version:    0.7.0.1
 */