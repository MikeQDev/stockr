/*  1:   */ package yahoofinance.histquotes;
/*  2:   */ 
/*  3:   */ public enum Interval
/*  4:   */ {
/*  5:10 */   DAILY("d"),  WEEKLY("w"),  MONTHLY("m");
/*  6:   */   
/*  7:   */   private final String tag;
/*  8:   */   
/*  9:   */   private Interval(String tag)
/* 10:   */   {
/* 11:17 */     this.tag = tag;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getTag()
/* 15:   */   {
/* 16:21 */     return this.tag;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.histquotes.Interval
 * JD-Core Version:    0.7.0.1
 */