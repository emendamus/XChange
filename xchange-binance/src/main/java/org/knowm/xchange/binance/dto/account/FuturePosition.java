package org.knowm.xchange.binance.dto.account;

import java.math.BigDecimal;
import org.knowm.xchange.binance.dto.PositionSide;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FuturePosition {
  
  private String symbol;
  private BigDecimal initialMargin;
  private BigDecimal maintMargin;
  private BigDecimal unrealizedProfit;
  private BigDecimal positionInitialMargin;
  private BigDecimal openOrderInitialMargin;
  private int leverage;
  private boolean isolated;
  private BigDecimal entryPrice;
  private BigDecimal maxNotional;
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
  private PositionSide positionSide;

}
