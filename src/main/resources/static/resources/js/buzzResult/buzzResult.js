'use strict';

/**
 * Buzz 수집현황 API 호출 함수
 * @param {*} parameter 
 * @param {*} callback 
 */
function call (parameter, callback)  {
  $.ajax({
    type: 'post',
    data: parameter,
    url: '/api/buzz_sum',
    success: function (data, status, xhr)  {
      if (data.status === 200 && data.message === 'SUCCESS' && data.data) {
        callback(data.data);
      } else {
        callback(null);
      }
    },
    error: function (xhr, status, err)  {
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
 * LineChart 생성 하는 함수
 */
function draw () {
  let period = getPeriod();
  let parameter = { startDate: period.startDate, endDate: period.endDate };

  call(parameter, function (res) {
    if (!res) {
      alert('데이터가 존재하지 않습니다.');
      return false;
    }

    lineChart('blogLineChart', 'Blog', res.blog, '#4bacc6');
    lineChart('newsLineChart', 'News', res.news, '#4bacc6');
    lineChart('twitterLineChart', 'Twitter', res.twitter, '#4bacc6');
    lineChart('instagramLineChart', 'Instagram', res.insta, '#4bacc6');
    lineChart('facebookLineChart', 'Facebook', res.facebook, '#4bacc6');
    lineChart('communityLineChart', 'Community', res.community, '#4bacc6');

    lineChart('blogSseLineChart', 'Samsung Blog', res.sec_blog_all, '#f79646');
    lineChart('newsSseLineChart', 'Samsung News', res.sec_news, '#f79646');
    lineChart('twitterSseLineChart', 'Samsung Twitter', res.sec_twitter, '#f79646');
    lineChart('instagramSseLineChart', 'Samsung Instagram', res.sec_insta, '#f79646');
    lineChart('facebookSseLineChart', 'Samsung Facebook', res.sec_facebook, '#f79646');
    lineChart('communitySseLineChart', 'Samsung Community', res.sec_community, '#f79646');
  });
}

$(function () {
  draw();

  $('input[name="daterange"]').on('apply.daterangepicker', function (event, picker) {
    draw();
  });
});