/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2025-04-15 15:28:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class posts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-3.0.1.jar", Long.valueOf(1744562959401L));
    _jspx_dependants.put("jar:file:/C:/Users/hakari/git/jsp-servlet-jar/src/main/webapp/WEB-INF/lib/jakarta.servlet.jsp.jstl-3.0.1.jar!/META-INF/c.tld", Long.valueOf(1664428278000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Quản lý bài viết</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        .post-form {\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .post-list {\r\n");
      out.write("            display: grid;\r\n");
      out.write("            gap: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .post-item {\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("        }\r\n");
      out.write("        .post-actions {\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            gap: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .btn {\r\n");
      out.write("            padding: 5px 10px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("        }\r\n");
      out.write("        .btn-edit {\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        .btn-delete {\r\n");
      out.write("            background-color: #f44336;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>Quản lý bài viết</h1>\r\n");
      out.write("<!-- Tác dụng: Hiển thị chữ lớn \"Quản lý bài viết\" trên trang -->\r\n");
      out.write("<!-- Đây là tiêu đề chính để bạn biết trang này dùng để làm gì -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"post-form\">\r\n");
      out.write("    <h2>Đăng bài mới</h2>\r\n");
      out.write("    <!-- Tác dụng: Hiển thị chữ \"Đăng bài mới\" trong phần form -->\r\n");
      out.write("    <!-- Cho bạn biết đây là nơi để tạo bài viết mới -->\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/post\" method=\"post\">\r\n");
      out.write("        <!-- Tác dụng: Tạo biểu mẫu để bạn nhập thông tin bài viết mới -->\r\n");
      out.write("        <!-- \"action='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/post'\": Dữ liệu sẽ được gửi đến \"/post\" trên máy chủ -->\r\n");
      out.write("        <!-- \"method='post'\": Dữ liệu (tiêu đề, nội dung) được gửi kín đáo qua POST, không hiện trên URL -->\r\n");
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <label for=\"title\">Tiêu đề:</label>\r\n");
      out.write("            <!-- Tác dụng: Hiển thị chữ \"Tiêu đề:\" để bạn biết ô này nhập gì -->\r\n");
      out.write("            <input type=\"text\" id=\"title\" name=\"title\" required>\r\n");
      out.write("            <!-- Tác dụng: Tạo ô để bạn gõ tiêu đề bài viết, ví dụ: \"Xin chào mọi người\" -->\r\n");
      out.write("            <!-- \"name='title'\": Đặt tên \"title\" để máy chủ nhận biết đây là tiêu đề -->\r\n");
      out.write("            <!-- \"required\": Bắt buộc phải nhập, không để trống -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <label for=\"body\">Nội dung:</label>\r\n");
      out.write("            <!-- Tác dụng: Hiển thị chữ \"Nội dung:\" để bạn biết ô này nhập gì -->\r\n");
      out.write("            <textarea id=\"body\" name=\"body\" required></textarea>\r\n");
      out.write("            <!-- Tác dụng: Tạo ô lớn để bạn gõ nội dung bài viết, ví dụ: \"Hôm nay là ngày đẹp trời\" -->\r\n");
      out.write("            <!-- \"name='body'\": Đặt tên \"body\" để máy chủ nhận biết đây là nội dung -->\r\n");
      out.write("            <!-- \"required\": Bắt buộc phải nhập -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-submit\">Đăng bài</button>\r\n");
      out.write("        <!-- Tác dụng: Tạo nút \"Đăng bài\" để gửi dữ liệu bạn vừa nhập -->\r\n");
      out.write("        <!-- Khi nhấp, tiêu đề và nội dung được gửi đến \"/post\" để lưu -->\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"post-list\">\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function deletePost(postId) {\r\n");
      out.write("        if (confirm('Bạn có chắc muốn xóa bài viết này?')) {\r\n");
      out.write("            fetch('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/post/' + postId, {\r\n");
      out.write("                method: 'DELETE'\r\n");
      out.write("            }).then(response => {\r\n");
      out.write("                if (response.ok) {\r\n");
      out.write("                    location.reload();\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    <!-- Tác dụng: Hàm này hỏi bạn có chắc muốn xóa bài viết không -->\r\n");
      out.write("    <!-- Nếu đồng ý, gửi yêu cầu DELETE đến \"/post/[ID]\" để xóa bài -->\r\n");
      out.write("    <!-- Khi xóa xong, trang tải lại để cập nhật danh sách -->\r\n");
      out.write("\r\n");
      out.write("    function editPost(postId) {\r\n");
      out.write("        const newTitle = prompt('Nhập tiêu đề mới:');\r\n");
      out.write("        const newBody = prompt('Nhập nội dung mới:');\r\n");
      out.write("        <!-- Tác dụng: Hỏi bạn tiêu đề và nội dung mới qua hai hộp thoại nhỏ -->\r\n");
      out.write("        <!-- Ví dụ: Bạn nhập \"Tiêu đề mới\" và \"Nội dung mới\" -->\r\n");
      out.write("\r\n");
      out.write("        if (newTitle && newBody) {\r\n");
      out.write("            const formData = new FormData();\r\n");
      out.write("            formData.append('title', newTitle);\r\n");
      out.write("            formData.append('body', newBody);\r\n");
      out.write("            <!-- Tác dụng: Tạo một gói dữ liệu chứa tiêu đề và nội dung mới -->\r\n");
      out.write("            <!-- Gói này giống như một phong bì để gửi thông tin đi -->\r\n");
      out.write("\r\n");
      out.write("            fetch('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/post/' + postId, {\r\n");
      out.write("                method: 'PUT',\r\n");
      out.write("                body: formData\r\n");
      out.write("            }).then(response => {\r\n");
      out.write("                if (response.ok) {\r\n");
      out.write("                    location.reload();\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("            <!-- Tác dụng: Gửi gói dữ liệu đến \"/post/[ID]\" bằng cách PUT để cập nhật bài viết -->\r\n");
      out.write("            <!-- Khi xong, trang tải lại để hiển thị bài đã sửa -->\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(jakarta.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /posts.jsp(82,4) name = items type = jakarta.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/posts.jsp(82,4) '${posts}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${posts}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /posts.jsp(82,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("post");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("        <!-- Tác dụng: Lặp qua danh sách bài viết từ máy chủ để hiển thị từng bài -->\r\n");
            out.write("        <!-- Mỗi bài được gán vào biến \"post\" để dùng trong vòng lặp -->\r\n");
            out.write("\r\n");
            out.write("        <div class=\"post-item\">\r\n");
            out.write("            <h3>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.title}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</h3>\r\n");
            out.write("            <!-- Tác dụng: Hiển thị tiêu đề của bài viết, ví dụ: \"Xin chào mọi người\" -->\r\n");
            out.write("            <!-- Lấy từ dữ liệu máy chủ để bạn thấy nội dung chính của bài -->\r\n");
            out.write("\r\n");
            out.write("            <p>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.body}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</p>\r\n");
            out.write("            <!-- Tác dụng: Hiển thị nội dung đầy đủ của bài viết -->\r\n");
            out.write("            <!-- Lấy từ dữ liệu máy chủ để bạn đọc toàn bộ bài -->\r\n");
            out.write("\r\n");
            out.write("            <small>Đăng bởi: ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.user.username}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(' ');
            out.write('-');
            out.write(' ');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.createdAt}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</small>\r\n");
            out.write("            <!-- Tác dụng: Hiển thị thông tin nhỏ về tác giả và thời gian đăng -->\r\n");
            out.write("            <!-- Ví dụ: \"Đăng bởi: Nam - 2025-04-02T10:00\" để bạn biết ai đăng và khi nào -->\r\n");
            out.write("\r\n");
            out.write("            ");
            if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\r\n");
            out.write("        </div>\r\n");
            out.write("    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(jakarta.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, jakarta.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    jakarta.servlet.jsp.PageContext pageContext = _jspx_page_context;
    jakarta.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent((jakarta.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /posts.jsp(99,12) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.role == 'ADMIN' || sessionScope.user.id == post.user.id}", boolean.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != jakarta.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                <!-- Tác dụng: Kiểm tra xem bạn có quyền sửa/xóa bài viết không -->\r\n");
          out.write("                <!-- Chỉ hiện nút \"Sửa\" và \"Xóa\" nếu bạn là ADMIN hoặc là người đăng bài -->\r\n");
          out.write("\r\n");
          out.write("                <div class=\"post-actions\">\r\n");
          out.write("                    <button onclick=\"editPost(`");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.id}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("`)\" class=\"btn btn-edit\">Sửa</button>\r\n");
          out.write("                    <!-- Tác dụng: Tạo nút \"Sửa\" để bạn chỉnh sửa bài viết -->\r\n");
          out.write("                    <!-- Khi nhấp, gọi hàm JavaScript editPost() với ID bài viết -->\r\n");
          out.write("\r\n");
          out.write("                    <button onclick=\"deletePost(`");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.id}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("`)\" class=\"btn btn-delete\">Xóa</button>\r\n");
          out.write("                    <!-- Tác dụng: Tạo nút \"Xóa\" để bạn xóa bài viết -->\r\n");
          out.write("                    <!-- Khi nhấp, gọi hàm JavaScript deletePost() với ID bài viết -->\r\n");
          out.write("                </div>\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != jakarta.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }
}
