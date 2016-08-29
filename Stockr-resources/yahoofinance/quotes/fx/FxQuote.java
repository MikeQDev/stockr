/*  1:   */ package yahoofinance.quotes.fx;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class FxQuote
/*  6:   */ {
/*  7:   */   private String symbol;
/*  8:   */   private BigDecimal price;
/*  9:   */   
/* 10:   */   public FxQuote(String symbol)
/* 11:   */   {
/* 12:16 */     this.symbol = symbol;
/* 13:17 */     this.price = BigDecimal.ZERO;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public FxQuote(String symbol, BigDecimal price)
/* 17:   */   {
/* 18:21 */     this.symbol = symbol;
/* 19:22 */     this.price = price;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getSymbol()
/* 23:   */   {
/* 24:26 */     return this.symbol;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setSymbol(String symbol)
/* 28:   */   {
/* 29:30 */     this.symbol = symbol;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public BigDecimal getPrice()
/* 33:   */   {
/* 34:40 */     if (this.price.equals(BigDecimal.ZERO)) {
/* 35:41 */       return getPrice(true);
/* 36:   */     }
/* 37:43 */     return this.price;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public BigDecimal getPrice(boolean refresh)
/* 41:   */   {
/* 42:60 */     if (refresh)
/* 43:   */     {
/* 44:61 */       FxQuotesRequest request = new FxQuotesRequest(this.symbol);
/* 45:62 */       this.price = ((FxQuote)request.getSingleResult()).getPrice();
/* 46:   */     }
/* 47:64 */     return this.price;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setPrice(BigDecimal price)
/* 51:   */   {
/* 52:68 */     this.price = price;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public String toString()
/* 56:   */   {
/* 57:73 */     return this.symbol + ": " + this.price;
/* 58:   */   }
/* 59:   */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.fx.FxQuote
 * JD-Core Version:    0.7.0.1
 */