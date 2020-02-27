'use strict';

/**
 * AmChart 4 컨테이너 객체 생성 & 반환 함수
 * @param {*} target : DOM Element ID (필수)
 * @param {*} width : 컨테이너 객체 가로 길이 (필수)
 * @param {*} height : 컨테이너 객체 세로 길이 (필수)
 */
function getContainer(target, width, height) {
  let container = am4core.create(target, am4core.Container);
  container.width = am4core.percent(width);
  container.height = am4core.percent(height);
  return container;
};

/**
 * Buzz 수집현황 Line 차트를 그려주는 함수
 * @param {*} target : DOM Element ID (필수)
 * @param {*} name : Series 이름 (필수)
 * @param {*} data : Buzz 수집현황 데이터 (필수)
 * @param {*} color : 차트 색상 (선택)
 */
function lineChart (target, name, data, color)  {
  let container = getContainer(target, 100, 100);
  let chart = container.createChild(am4charts.XYChart);

  chart.data = data;

  let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
  categoryAxis.dataFields.category = 'basisDate';
  categoryAxis.cursorTooltipEnabled = false;
  categoryAxis.renderer.labels.template.fontSize = 12; //폰트 사이즈
  categoryAxis.renderer.labels.template.fill = am4core.color('#505669'); //x축 글씨색
  categoryAxis.renderer.grid.template.stroke = am4core.color('#dbdbdb'); //그리드 컬러	
  categoryAxis.renderer.labels.template.fontFamily = 'Helvetica Neue, Arial, "NotoL", sans-serif';
  categoryAxis.renderer.grid.template.location = 0.5;
  categoryAxis.renderer.labels.template.disabled = true;
  categoryAxis.startLocation = 0.5;
  categoryAxis.endLocation = 0.5;

  let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
  valueAxis.min = 0; //시작점 0 부터
  valueAxis.marginLeft = -20; //Y축 왼쪽으로 당기기
  valueAxis.cursorTooltipEnabled = false;
  valueAxis.renderer.minLabelPosition = 0.01;
  valueAxis.renderer.labels.template.fontSize = 12; //폰트 사이즈
  valueAxis.renderer.labels.template.fill = am4core.color('#505669'); //Y축 글씨색
  valueAxis.renderer.grid.template.stroke = am4core.color('#dbdbdb'); //그리드 컬러	
  valueAxis.renderer.labels.template.fontFamily = 'Helvetica Neue, Arial, "NotoL", sans-serif';
  valueAxis.renderer.labels.template.disabled = true;

  /**
   * Line Series 를 추가하는 함수
   * @param {*} x : 가로축 키 값
   * @param {*} y : 세로축 키 값
   * @param {*} name : Series 이름
   * @param {*} color : 차트 색상
   */
  function create(x, y, name, color) {
    var series = chart.series.push(new am4charts.LineSeries());
    series.name = name;
    series.strokeWidth = 2;
    series.fillOpacity = 0.1;
    series.dataFields.valueY = y;
    series.dataFields.categoryX = x;
    series.width = am4core.percent(100);
    series.legendSettings.valueText = '{valueY}';

    series.tooltip.fontSize = 13; //툴팁 폰트 크기
    series.fill = am4core.color(color);
    series.stroke = am4core.color(color);
    series.tooltip.autoTextColor = false; //툴팁 사용자 커스텀 옵션 false = 사용 
    series.tooltip.getFillFromObject = false; //툴팁 백그라운트 컬러 사용자 옵션 false = 사용
    series.tooltip.background.fillOpacity = 1;
    series.tooltip.label.fill = am4core.color("#505669"); //툴팁 폰트 색
    series.tooltip.background.strokeWidth = 2; //툴팁 보더 두께
    series.tooltip.background.stroke = series.fill; //툴팁 보더 색
    series.tooltip.background.fill = am4core.color("white"); //툴팁 백그라운드 색        
    series.tooltipText = "[bold]{name}[/]\n{categoryX}: {valueY.formatNumber(#,###)}건";
  }

  create('basisDate', 'documentCount', name, color);

  chart.cursor = new am4charts.XYCursor();
  chart.cursor.behavior = 'none';
  chart.cursor.lineX.disabled = true;
  chart.cursor.lineY.disabled = true;

  chart.zoomOutButton.disabled = true;
  chart.zoomOutButton.icon.disabled = true;
}