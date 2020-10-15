package org.knowm.xchange.binance.dto.marketdata;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BinanceFutureMarkPrice {
  
  private String symbol;
  private BigDecimal markPrice;
  private BigDecimal lastFundingRate;
  private long nextFundingTime;
  private long time;
  
  public Date getNextFundingTime() {
    return new Date(nextFundingTime);
  }
  
  public Date getTime() {
    return new Date(time);
  }

}
