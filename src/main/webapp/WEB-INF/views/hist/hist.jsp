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
        <div class="row" style="position: relative;"></div>

        <div class="row" style="position: sticky;">
          <div class="col-lg-12">
            <div class="ibox ">
              <div class="ibox-title">
                <h3>Social Metrics Service Monitoring</h3>
                <div class="ibox-tools" style="width: 16.5%; top: 12px;">
                  <div class="input-group date">
                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                    <input class="form-control" type="text" name="daterange" value="2020-01-01 - 2020-01-31">
                  </div>
                </div>
              </div>
              <div class="ibox-content">
                <div class="row">
                  <button class="btn btn-default dim btn-sm-dim" type="button" style="float: left; margin-left: 10px;">ASP Service</button>
                  <button class="btn btn-default dim btn-sm-dim" type="button" style="float: left; margin-left: 10px;">SOME Service</button>
                  <button class="btn btn-default dim btn-sm-dim" type="button" style="float: left; margin-left: 10px;">REVIEW+ Service</button>
                  <button class="btn btn-default dim btn-sm-dim" type="button" style="float: left; margin-left: 10px;">OTHER Service</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
        
        <div class="wrapper wrapper-content animated fadeInRight">

          <div class="row">
            <div class="col-lg-12">
              <div class="ibox ">
                <div class="ibox-title" style="background-color: #1AB394;">
                  <h2 style="color: #FFFFFF; font-weight: bold;">ASP Service</h2>
                </div>
              </div>
            </div>
          </div>
          
          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>KB Card</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="kbCardLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="kbCardPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="kbCardQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>BC Card</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bcCardLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bcCardPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bcCardQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>대홍기획</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="daehongLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="daehongPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="daehongQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>삼성전자</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="samsungLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="samsungPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="samsungQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>SBS</h5>
                  <span id="sbsAppStatus" class="badge">DOWN</span>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="sbsLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="sbsPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="sbsQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="position: sticky;">
            <div class="col-lg-12">
              <div class="ibox ">
                <div class="ibox-title" style="background-color: #1AB394;">
                  <h2 style="color: #FFFFFF; font-weight: bold;">SOME Service</h2>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>썸트렌드</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="someTrendLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="someTrendPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="someTrendQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>BIZ</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bizLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bizPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="bizQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="position: sticky;">
            <div class="col-lg-12">
              <div class="ibox ">
                <div class="ibox-title" style="background-color: #1AB394;">
                  <h2 style="color: #FFFFFF; font-weight: bold;">REVIEW+ Service</h2>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>Beauty</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="reviewBeautyLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="reviewBeautyPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="reviewBeautyQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" style="position: sticky;">
            <div class="col-lg-12">
              <div class="ibox ">
                <div class="ibox-title" style="background-color: #1AB394;">
                  <h2 style="color: #FFFFFF; font-weight: bold;">OTHER Service</h2>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>보험사기</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="fakeInsuranceLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="fakeInsurancePageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="fakeInsuranceQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>쿼리툴</h5>
                  <span id="querytoolAppStatus" class="badge">DOWN</span>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="querytoolLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="querytoolPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="querytoolQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="row" id="sortable-view">
            <div class="col-lg-12">
              <div class="ibox" style="opacity: 1;">
                <div class="ibox-title">
                  <h5>주식뉴스</h5>
                </div>
                <div class="ibox-content">
                  <div class="row" id="sortable-view">
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>LOGIN</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="stockNewsLoginLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>PAGE VIEW</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="stockNewsPageLineChart"></div>
                        </div>
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="ibox" style="opacity: 1;">
                        <div class="ibox-title">
                          <h5>QUERY</h5>
                        </div>
                        <div class="ibox-content">
                          <div id="stockNewsQueryLineChart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
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
  <script type="text/javascript" src="/resources/js/hist/chart.js?v=<%=System.currentTimeMillis() %>"></script>
  <script type="text/javascript" src="/resources/js/hist/hist.js?v=<%=System.currentTimeMillis() %>"></script>
</body>

</html>