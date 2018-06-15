package CHNTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class CHNLabledTextField extends TagSupport
{
	public String value = "";
	public String lable = "";
	public String name = "";

	public String getValue() {return value;}

	public void setValue(String val) {this.value = val;}

	public String getLable() {return lable;}

	public void setLable(String val) {this.lable = val;}

	public String getName() {return name;}

	public void setName(String val) {this.name = val;}

	public int doStartTag() throws JspException
	{
		JspWriter out = pageContext.getOut();
		try
		{
			//"<tr><td>" + Name + "</td><td> " + Value + "</td></tr>"
			out.print("<tr width=\"100%\"><td width=\"200px\">" + lable + "</td><td><input name =\"" + name + "value =\"" + this.value + "\" width = \"25%\"/></td></tr>");
		} catch(IOException e)
		{
			System.out.println("CHNTag LabledTextField Exception: " + e);
		}
		return SKIP_BODY;
	}
}