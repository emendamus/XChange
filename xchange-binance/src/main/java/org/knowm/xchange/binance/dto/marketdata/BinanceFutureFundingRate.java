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
public class BinanceFutureFundingRate {

  private String symbol;
  private BigDecimal fundingRate;
  private long fundingTime;
  private long time;
  
  public Date getFundingTime() {
    return new Date(fundingTime);
  }
  
  public Date getTime() {
    return new Date(time);
  }

}
