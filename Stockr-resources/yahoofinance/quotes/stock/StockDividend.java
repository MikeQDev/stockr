/*  1:   */ package yahoofinance.quotes.stock;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ import java.util.Calendar;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class StockDividend
/*  8:   */ {
/*  9:   */   private final String symbol;
/* 10:   */   private Calendar payDate;
/* 11:   */   private Calendar exDate;
/* 12:   */   private BigDecimal annualYield;
/* 13:   */   private BigDecimal annualYieldPercent;
/* 14:   */   
/* 15:   */   public StockDividend(String symbol)
/* 16:   */   {
/* 17:21 */     this.symbol = symbol;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public StockDividend(String symbol, Calendar payDate, Calendar exDate, BigDecimal annualYield, BigDecimal annualYieldPercent)
/* 21:   */   {
/* 22:25 */     this(symbol);
/* 23:26 */     this.payDate = payDate;
/* 24:27 */     this.exDate = exDate;
/* 25:28 */     this.annualYield = annualYield;
/* 26:29 */     this.annualYieldPercent = annualYieldPercent;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getSymbol()
/* 30:   */   {
/* 31:33 */     return this.symbol;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Calendar getPayDate()
/* 35:   */   {
/* 36:37 */     return this.payDate;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setPayDate(Calendar payDate)
/* 40:   */   {
/* 41:41 */     this.payDate = payDate;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Calendar getExDate()
/* 45:   */   {
/* 46:45 */     return this.exDate;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setExDate(Calendar exDate)
/* 50:   */   {
/* 51:49 */     this.exDate = exDate;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public BigDecimal getAnnualYield()
/* 55:   */   {
/* 56:53 */     return this.annualYield;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setAnnualYield(BigDecimal annualYield)
/* 60:   */   {
/* 61:57 */     this.annualYield = annualYield;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public BigDecimal getAnnualYieldPercent()
/* 65:   */   {
/* 66:61 */     return this.annualYieldPercent;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setAnnualYieldPercent(BigDecimal annualYieldPercent)
/* 70:   */   {
/* 71:65 */     this.annualYieldPercent = annualYieldPercent;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public String toString()
/* 75:   */   {
/* 76:70 */     String payDateStr = "/";
/* 77:71 */     String exDateStr = "/";
/* 78:72 */     if (this.payDate != null) {
/* 79:73 */       payDateStr = this.payDate.getTime().toString();
/* 80:   */     }
/* 81:75 */     if (this.exDate != null) {
/* 82:76 */       exDateStr = this.exDate.getTime().toString();
/* 83:   */     }
/* 84:78 */     return "Pay date: " + payDateStr + ", Ex date: " + exDateStr + ", Annual yield: " + getAnnualYieldPercent() + "%";
/* 85:   */   }
/* 86:   */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.quotes.stock.StockDividend
 * JD-Core Version:    0.7.0.1
 */