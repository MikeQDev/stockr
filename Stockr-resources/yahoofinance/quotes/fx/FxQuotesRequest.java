/*  1:   */ package yahoofinance.quotes.fx;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ import yahoofinance.Utils;
/*  6:   */ import yahoofinance.quotes.QuotesProperty;
/*  7:   */ import yahoofinance.quotes.QuotesRequest;
/*  8:   */ 
/*  9:   */ public class FxQuotesRequest
/* 10:   */   extends QuotesRequest<FxQuote>
/* 11:   */ {
/* 12:17 */   public static final List<QuotesProperty> DEFAULT_PROPERTIES = new ArrayList();
/* 13:   */   
/* 14:   */   static
/* 15:   */   {
/* 16:19 */     DEFAULT_PROPERTIES.add(QuotesProperty.Symbol);
/* 17:20 */     DEFAULT_PROPERTIES.add(QuotesProperty.LastTradePriceOnly);
/* 18:   */   }
/* 19:   */   
/* 20:   */   public FxQuotesRequest(String query)
/* 21:   */   {
/* 22:24 */     super(query, DEFAULT_PROPERTIES);
/* 23:   */   }
/* 24:   */   
/* 25:   */   protected FxQuote parseCSVLine(String line)
/* 26:   */   {
/* 27:29 */     String[] split = Utils.stripOverhead(line).split(",");
/* 28:30 */     if (split.length >= 2) {
/* 29:31 */       return new FxQuote(split[0], Utils.getBigDecimal(split[1]));
/* 30:   */     }
/* 31:33 */     return null;
/* 32:   */   }
/* 33:   */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.fx.FxQuotesRequest
 * JD-Core Version:    0.7.0.1
 */