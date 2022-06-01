package com.bjpn.servlet;

import com.bjpn.bean.Emp;
import com.bjpn.service.EmpService;
import com.bjpn.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet("/emp.action")
@MultipartConfig
public class EmpServlet extends HttpServlet {
    EmpService empService=new EmpServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        System.out.println(flag);
        if ("saveEmp".equals(flag)) {
            saveEmp(request, response);
        } else if ("findAllEmp".equals(flag)) {
            findAllEmp(request,response);
        } else if ("delete".equals(flag)) {
            deleteEmp(request, response);
        }
    }

    private void saveEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empName = request.getParameter("empName");
        String empJob = request.getParameter("empJob");
        String empHiredate = request.getParameter("hiredate");
        String sal = request.getParameter("empSal");
        double empSal = Double.parseDouble(sal);
        String dno = request.getParameter("deptNo");
        int deptNo = Integer.parseInt(dno);
        Part part = request.getPart("upImg");
        String oldFileName = part.getSubmittedFileName();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileType = oldFileName.substring(oldFileName.indexOf("."));
        String fileName = uuid + fileType;
        String path = request.getServletContext().getRealPath("/fileupload");
        part.write(path + "/" + fileName);
        Emp emp = new Emp();
        emp.setEmpName(empName);
        emp.setEmpJob(empJob);
        emp.setEmpHiredate(empHiredate);
        emp.setEmpSal(empSal);
        emp.setEmpNo(deptNo);
        emp.setEmpPhoto(fileName);
        boolean b = empService.savaEmp(emp);
        if (b) {
            response.sendRedirect("emp.action?flag=findAllEmp");
        } else {
            request.setAttribute("errorMessage", "添加失败");
            request.getRequestDispatcher("page/emp/addEmp.jsp").forward(request, response);
        }
    }


    private void findAllEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> listEmp = empService.findAllEmp();
        request.setAttribute("listEmp", listEmp);
        request.getRequestDispatcher("page/emp/emp.jsp").forward(request, response);
    }

    private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String empNo = request.getParameter("empNo");
        System.out.println(empNo);
        boolean b = empService.deleteEmp(empNo);
        PrintWriter out = response.getWriter();
        if (b) {
            out.write("ok");
            System.out.println("删除成功");
        } else {
            out.write("删除失败");
            System.out.println("删除失败");
        }
    }

}
