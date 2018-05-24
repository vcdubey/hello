package vcd;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public First() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray arr = new JSONArray();
		arr = DBActivity.fetchAllRecord();
		System.out.println(arr.toJSONString());
		response.getWriter().append(arr.toJSONString());
	}


}
