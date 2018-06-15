package CHNTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Enumeration;

public class CHNTable extends TagSupport
{
	public int doStartTag() throws JspException
	{
		try
		{
			JspWriter out = pageContext.getOut();
			out.print("<table border=\"1\" width=\"100%\"><tr><th width=\"200px\">Name</th><th>Value</th></tr>");
			Enumeration params = pageContext.getRequest().getParameterNames();
			while(params.hasMoreElements())
			{
				String Name = (String) params.nextElement();
				String Value = pageContext.getRequest().getParameter(Name);
				out.println("<tr><td>" + Name + "</td><td> " + Value + "</td></tr>");
			}
			out.print("</table>");
		} catch(IOException e)
		{
			System.out.println("CHNTable tag exception: " + e);
		}
		return EVAL_BODY_INCLUDE;
	}
}