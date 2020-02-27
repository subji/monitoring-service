'use strict';

/**
 * 로그량 API 호출 함수
 * @param {*} parameter 
 * @param {*} callback 
 */
function call(url, parameter, callback) {
  $.ajax({
    url: url,
    type: 'get',
    data: parameter,
    success: function (data, status, xhr) {
      if (data.status === 200 && data.message === 'SUCCESS' && data.data) {
        callback(data.data);
      } else {
        callback(null);
      }
    },
    error: function (xhr, status, err) {
      console.error(err);
      callback(null);
    }
  });
}

/**
 * Date Range Picker 기간 (시작, 종료날짜) 호출 함수
 */
function getPeriod () {
  let startDate = moment($('input[name="daterange"]').data('daterangepicker').startDate).toDate().formatDate('');
  let endDate = moment($('input[name="daterange"]').data('daterangepicker').endDate).toDate().formatDate('');

  return { startDate: startDate, endDate: endDate };
}

/**
 * 어플리케이션 활성 상태를 받아오는 함수
 * @param {*} callback 
 */
function checkStatus (appName, callback) {
  $.ajax({
    type: 'get',
    url: '/status',
    data: { applicationName: appName },
    // contentType: 'application/json;charset=utf-8',
    success: function (data, status, xhr)  {
      if (data.status === 200 && data.message === 'SUCCESS' && data)  {
        callback(data.data);
      }
    },
    error: function (xhr, status, err)  {
      console.error(err);
      callback(null);
    }
  });
}

/**
 * LineChart 생성 하는 함수
 */
function draw (appName, appUrl) {
  let period = getPeriod();
  let parameter = { startDate: period.startDate, endDate: period.endDate, url: appUrl };
  let $status = $('#' + appName + 'AppStatus');

  checkStatus(appName, function (res) {
    if (res.status === 'UP')  {
      $status.attr('class', 'badge badge-primary').text('UP');

      call('/api/log/login', parameter, function (res) {
        if (!res) {
          alert('데이터가 존재하지 않습니다.');
          return false;
        }
        lineChart(appName + 'LoginLineChart', 'Login', res, '#4bacc6');
      });

      call('/api/log/page', parameter, function (res) {
        if (!res) {
          alert('데이터가 존재하지 않습니다.');
          return false;
        }
        lineChart(appName + 'PageLineChart', 'Page', res, '#4bacc6');
      });

      call('/api/log/query', parameter, function (res) {
        if (!res) {
          alert('데이터가 존재하지 않습니다.');
          return false;
        }
        lineChart(appName + 'QueryLineChart', 'Query', res, '#4bacc6');
      });
    } else {
      $status.attr('class', 'badge badge-dange').text('DOWN');
    }
  });
}

/**
 * 로그량 실행 함수
 */
function execute () {
  let apps = {
    querytool: 'https://querytool.some.co.kr',
    sbs: 'http://social.sbs.co.kr'
  };

  Object.keys(apps).forEach(function (app) {
    let url = apps[app];
    draw(app, url);
  });
}

$(function () {
  execute();

  $('input[name="daterange"]').on('apply.daterangepicker', function (event, picker) {
    execute();
  });
});