<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/common/taglib.jsp" %>

<!DOCTYPE html>
<html>

<head>
  <%@include file="/WEB-INF/views/common/meta.jsp" %>
  <%@include file="/WEB-INF/views/common/style.jsp" %>
  <title>Social Metrics Monitoring</title>
</head>

<body class="top-navigation">

  <div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
      <div class="row border-bottom white-bg">
        <%@include file="/WEB-INF/views/common/navi.jsp" %>
      </div>

      <div class="wrapper wrapper-content">
        <div class="row">
          <div class="col-lg-12">
            <div class="ibox ">
              <div class="ibox-title">
                <h3>수집 현황 모니터링 대시보드</h3>
                <div class="ibox-tools" style="width: 16.5%; top: 12px;">
                  <div class="input-group date">
                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                    <input class="form-control" type="text" name="daterange" value="2020-01-01 - 2020-01-31">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="wrapper wrapper-content animated fadeInRight">
          <div class="row" id="sortable-view">
            <div class="col-lg-4">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>트위터</h5>
                </div>
                <div class="ibox-content">
                  <div id="twitterLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>블로그</h5>
                </div>
                <div class="ibox-content">
                  <div id="blogLineChart"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-4">
              <div class="ibox">
                <div class="ibox-title">
                  <h5>페이스북</h5>
                </div>
                <div class="ibox-content">
                  <div id="facebookLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>커뮤니티</h5>
                </div>
                <div class="ibox-content">
                  <div id="communityLineChart"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 ui-sortable">
              <div class="ibox">
                <div class="ibox-title">
                  <h5>인스타그램</h5>
                </div>
                <div class="ibox-content">
                  <div id="instagramLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>뉴스</h5>
                </div>
                <div class="ibox-content">
                  <div id="newsLineChart"></div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-4">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>삼성 트위터</h5>
                </div>
                <div class="ibox-content">
                  <div id="twitterSseLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>삼성 블로그</h5>
                </div>
                <div class="ibox-content">
                  <div id="blogSseLineChart"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-4">
              <div class="ibox">
                <div class="ibox-title">
                  <h5>삼성 페이스북</h5>
                </div>
                <div class="ibox-content">
                  <div id="facebookSseLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>삼성 커뮤니티</h5>
                </div>
                <div class="ibox-content">
                  <div id="communitySseLineChart"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 ui-sortable">
              <div class="ibox">
                <div class="ibox-title">
                  <h5>삼성 인스타그램</h5>
                </div>
                <div class="ibox-content">
                  <div id="instagramSseLineChart"></div>
                </div>
              </div>
              <div class="ibox">
                <div class="ibox-title">
                  <h5>삼성 뉴스</h5>
                </div>
                <div class="ibox-content">
                  <div id="newsSseLineChart"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <%@include file="/WEB-INF/views/common/footer.jsp" %>
      </div>
    </div>
  </div>

  <%@include file="/WEB-INF/views/common/script.jsp" %>
  <script type="text/javascript" src="/resources/js/buzzResult/chart.js?v=<%=System.currentTimeMillis() %>"></script>
  <script type="text/javascript" src="/resources/js/buzzResult/buzzResult.js?v=<%=System.currentTimeMillis() %>"></script>
</body>

</html>