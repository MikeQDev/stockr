/*   1:    */ package yahoofinance.histquotes;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.text.SimpleDateFormat;
/*   5:    */ import java.util.Calendar;
/*   6:    */ 
/*   7:    */ public class HistoricalQuote
/*   8:    */ {
/*   9:    */   private String symbol;
/*  10:    */   private Calendar date;
/*  11:    */   private BigDecimal open;
/*  12:    */   private BigDecimal low;
/*  13:    */   private BigDecimal high;
/*  14:    */   private BigDecimal close;
/*  15:    */   private BigDecimal adjClose;
/*  16:    */   private long volume;
/*  17:    */   
/*  18:    */   public HistoricalQuote() {}
/*  19:    */   
/*  20:    */   public HistoricalQuote(String symbol, Calendar date, BigDecimal open, BigDecimal low, BigDecimal high, BigDecimal close, BigDecimal adjClose, long volume)
/*  21:    */   {
/*  22: 30 */     this.symbol = symbol;
/*  23: 31 */     this.date = date;
/*  24: 32 */     this.open = open;
/*  25: 33 */     this.low = low;
/*  26: 34 */     this.high = high;
/*  27: 35 */     this.close = close;
/*  28: 36 */     this.adjClose = adjClose;
/*  29: 37 */     this.volume = volume;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public String getSymbol()
/*  33:    */   {
/*  34: 41 */     return this.symbol;
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void setSymbol(String symbol)
/*  38:    */   {
/*  39: 45 */     this.symbol = symbol;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public Calendar getDate()
/*  43:    */   {
/*  44: 49 */     return this.date;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public void setDate(Calendar date)
/*  48:    */   {
/*  49: 53 */     this.date = date;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public BigDecimal getOpen()
/*  53:    */   {
/*  54: 57 */     return this.open;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public void setOpen(BigDecimal open)
/*  58:    */   {
/*  59: 61 */     this.open = open;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public BigDecimal getLow()
/*  63:    */   {
/*  64: 69 */     return this.low;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public void setLow(BigDecimal low)
/*  68:    */   {
/*  69: 73 */     this.low = low;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public BigDecimal getHigh()
/*  73:    */   {
/*  74: 81 */     return this.high;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public void setHigh(BigDecimal high)
/*  78:    */   {
/*  79: 85 */     this.high = high;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public BigDecimal getClose()
/*  83:    */   {
/*  84: 89 */     return this.close;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public void setClose(BigDecimal close)
/*  88:    */   {
/*  89: 93 */     this.close = close;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public BigDecimal getAdjClose()
/*  93:    */   {
/*  94:105 */     return this.adjClose;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public void setAdjClose(BigDecimal adjClose)
/*  98:    */   {
/*  99:109 */     this.adjClose = adjClose;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public long getVolume()
/* 103:    */   {
/* 104:113 */     return this.volume;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public void setVolume(long volume)
/* 108:    */   {
/* 109:117 */     this.volume = volume;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public String toString()
/* 113:    */   {
/* 114:122 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 115:123 */     String dateStr = dateFormat.format(this.date.getTime());
/* 116:124 */     return this.symbol + "@" + dateStr + ": " + this.low + "-" + this.high + ", " + this.open + "->" + this.close + " (" + this.adjClose + ")";
/* 117:    */   }
/* 118:    */ }


/* Location:           C:\Users\Mike\Desktop\YahooFinanceAPI-1.4.0.jar
 * Qualified Name:     yahoofinance.histquotes.HistoricalQuote
 * JD-Core Version:    0.7.0.1
 */