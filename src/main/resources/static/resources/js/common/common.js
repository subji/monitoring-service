'use strict';
/**
 * 초기 날짜 설정 함수
 */
function initDate ()  {
  // 최초 날짜: 오늘 날짜 기준 한달전 ~ 오늘 날짜
  let initStartDate = new Date().changeMonth(-1);
  let initEndDate = new Date();

  $('input[name="daterange"]').daterangepicker({
    opens: 'left',
    autoApply: true,
    showDropdowns: true,
    maxDate: new Date(),
    endDate: initEndDate,
    startDate: initStartDate,
    locale: {
      format: 'YYYY-MM-DD',
      separator: ' ~ ',
      daysOfWeek: ['일', '월', '화', '수', '목', '금', '토'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
    }
  });
}

$(function () {
  initDate();
});