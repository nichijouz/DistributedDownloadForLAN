<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
	<title>View Exported Items</title>
	<style type="text/css">
		body
		  { color:#313131; font-size:9pt; font-family: Arial, Verdana, Helvetica, sans-serif }
		tr
		  { font-size:8pt; font-family: Arial, Verdana, Helvetica, sans-serif }
		A:link    {text-decoration:none;color:#4060e0}
		A:visited {text-decoration:none;color:#4060e0}
		A:active  {text-decoration:none;color:#4060e0}
		A:hover	  {text-decoration:underline;color:#FF6600}
		.mfont    { font-size:11pt }
		.sfont    { font-size:7pt }
		.tfont    { font-family: Verdana }
	</style>
</head>

<body bgcolor="#FFFFFF" topmargin="10" leftmargin="6" rightmargin="6" >
	<a name="top"></a>
	<center>

	<xsl:apply-templates select="ExportedItems"/>

	</center>

  <br/>
  <center>
	<span style="font-family:Verdana; font-size:8pt">
	  <a href="http://www.hainsoft.com/">Powered by LanHelper</a>
	</span>
  </center>
  <br/><br/>
</body>
</html>
</xsl:template>


<xsl:template match="ExportedItems">

<span style="font-family:Verdana; font-size:15pt; color:#404040">
  <b> <xsl:value-of select="./@title"/> </b>
</span>
  <br/><br/><br/>

<div align="right">
  Items: <xsl:value-of select="count(Item)"/>  
</div>
  <br/>

<table bgcolor="#444444" border="0" cellpadding="0" cellspacing="0" width="99%"><tr><td>
<table border="0" cellpadding="2" cellspacing="1" width="100%">
<tr bgcolor="#7799BB" class="tfont">
	<xsl:for-each select="Item[position()=1]/*">
	  <td align="center"><font color="#FFFFFF"><b>
	    <xsl:value-of select="name()"/>
	  </b></font></td>
	</xsl:for-each>
</tr>

<xsl:for-each select="Item">
  <tr bgcolor="#FFFFFF">
    <xsl:for-each select="*">
      <td>
        <xsl:value-of select="text()"/>
	  </td>
    </xsl:for-each>
  </tr>
</xsl:for-each>
 
 </table>
 </td></tr></table>
</xsl:template>
</xsl:stylesheet>