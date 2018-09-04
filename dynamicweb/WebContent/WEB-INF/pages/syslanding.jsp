<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="icon" href="<c:url value="/resources/bootstrap/favicon.ico" />">
    <title>Dashboard Template for Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/bootstrap/css/dashboard.css" />" rel="stylesheet">
    <style>
	    #_content {
		  width: 100px;
		  height: 100px;
		  position: relative;
		}
		#navi,
		#_result {
		  width: 1300%;
		  min-height: 400px;
		  position: absolute;
		  top: 0;
		  left: 0;
		}
		#_result {
		  z-index: 10;
		}
    </style>
  </head>

  <body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sign out</a>
        </li>
      </ul>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="#">
                  <span data-feather="home"></span>
                  Dashboard <span class="sr-only">(current)</span>
                </a>
              </li>
              <!-- start -->
              <li class="nav-item">
                <a class="nav-link" onclick="_openmenu('column');" href="javascript:void(0);" ><span data-feather="file"></span>Columns</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);" onclick="_openmenu('category');"><span data-feather="file"></span>List Category</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);" onclick="_openmenu('list');"><span data-feather="file"></span>List</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);" onclick="_openmenu('form');"><span data-feather="file"></span>Forms</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="javascript:void(0);" onclick="_openmenu('mapping');"><span data-feather="file"></span>Mappings</a>
              </li>              
              <!-- end -->
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="shopping-cart"></span>
                  Products
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="users"></span>
                  Customers
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="bar-chart-2"></span>
                  Reports
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="layers"></span>
                  Integrations
                </a>
              </li>
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Saved reports</span>
              <a class="d-flex align-items-center text-muted" href="#">
                <span data-feather="plus-circle"></span>
              </a>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Current month
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Last quarter
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Social engagement
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Year-end sale
                </a>
              </li>
            </ul>
          </div>
        </nav>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div id="_landing" class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3"></div>
        </main>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
 
    <script src="<c:url value="/resources/vendor/popper.min.js" />"></script>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/vendor/jquery.min.js" />"></script>
    <!-- Icons -->
    <script src="<c:url value="/resources/icon/feather.min.js" />"></script>
    <script>
      feather.replace()
    </script>

    <!-- Graphs -->
    <script src="<c:url value="/resources/chart/Chart.min.js" />"></script>
    <script>
    var _openmenu = function _openmenu(_loadmenu){
    	var _url = "http://localhost:8084/dynamicweb/ui/sys/" + _loadmenu;
    	$("#_landing").load(_url);
    }
      var ctx = document.getElementById("myChart");
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
          datasets: [{
            data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
            lineTension: 0,
            backgroundColor: 'transparent',
            borderColor: '#007bff',
            borderWidth: 4,
            pointBackgroundColor: '#007bff'
          }]
        },
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: false
              }
            }]
          },
          legend: {
            display: false,
          }
        }
      });
    </script>
  </body>
</html>
