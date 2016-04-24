package servlets;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import DAOs.PhotoDAO;
import exceptions.DataBaseProblemException;
import instagram.Photo;

@WebServlet("/Upload")

public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 6772794696312146031L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getParameter("file");
		PhotoDAO dao = new PhotoDAO();
		dao.addPhoto(p, url);
		
	}
}