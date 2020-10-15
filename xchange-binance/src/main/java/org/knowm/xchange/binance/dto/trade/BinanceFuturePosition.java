package org.knowm.xchange.binance.dto.trade;

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
public class BinanceFuturePosition {
  
  private String symbol;
  private BigDecimal entryPrice;
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
  private MarginType marginType;
  private boolean isAutoAddMargin;
  private BigDecimal isolatedMargin;
  private int leverage;
  private BigDecimal liquidationPrice;
  private BigDecimal markPrice;
  private BigDecimal maxNotionalValue;
  private BigDecimal positionAmt;
  private BigDecimal unRealizedProfit;
  @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
  private PositionSide positionSide;

}
