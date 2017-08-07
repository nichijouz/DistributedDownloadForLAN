<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
<head>
<title>LanHelper Machine Data</title>
<style type="text/css">
body
  { color:#313131; font-size:9pt; font-family: Verdana, Arial, Helvetica, sans-serif }
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
<div align="center">
    <span style="font-family:Verdana; font-size:15pt; color:#404040">
      <b>LanHelper Machine Data</b>
    </span>
<br/><br/><br/></div>
<div align="center">

<xsl:apply-templates select="addrlist"/>

<br/><br/><br/></div>
<div align="center">

  <span style="font-family:Verdana; font-size:8pt">
    <a href="http://www.hainsoft.com/">Powered by LanHelper</a>
  </span>
</div>
</body>
</html>
</xsl:template>

<xsl:template match="addrlist">

<table bgcolor="#FFFFFF" border="0" width="980"><tr><td>
<div align="right">
Machines: <xsl:value-of select="count(address)"/>&#160;&#160;
</div>
</td></tr></table>

<!-- table 1 start -->
<table bgcolor="#444444" border="0" cellpadding="0" cellspacing="0" width="980"><tr><td>
<table border="0" cellpadding="2" cellspacing="1" width="100%" style="table-layout:fixed">
    <tr bgcolor="#7799BB" class="tfont">
      <td width="18%" align="center"><font color="#FFFFFF"><b>Name</b></font></td>
      <td width="12%" align="center"><font color="#FFFFFF"><b>IP</b></font></td>
      <td width="12%" align="center"><font color="#FFFFFF"><b>MAC</b></font></td>
      <td width="12%" align="center"><font color="#FFFFFF"><b>Workgroup</b></font></td>
      <td width="12%" align="center"><font color="#FFFFFF"><b>User</b></font></td>
      <td width="10%" align="center"><font color="#FFFFFF"><b>OS</b></font></td>
      <td width="10%" align="center"><font color="#FFFFFF"><b>Server</b></font></td>
      <td width="14%" align="center"><font color="#FFFFFF"><b>Comment</b></font></td>
    </tr>
    <xsl:for-each select="address">
        <tr bgcolor="#FFFFFF">
        <td><xsl:value-of select="hostname"/>
        
        <!-- hyper link for machine name -->
        
        &#160;&#160;
        <xsl:element name="a">
          <xsl:attribute name="href">#<xsl:value-of select="position()"/></xsl:attribute>
          <font color="#B0B0FF" face="Verdana"><span style="font-size:6pt">&gt;&gt;</span></font>
        </xsl:element>
        </td>
        <td><xsl:value-of select="ip"/></td>
        <td><xsl:value-of select="mac"/></td>
        <td><xsl:value-of select="server"/></td>
        <td><xsl:value-of select="user"/></td>
        <td><xsl:value-of select="hostname/@os"/></td>
        <td><xsl:value-of select="hostname/@servertype"/></td>
        <td><xsl:value-of select="comment"/></td>
        </tr>
    </xsl:for-each>
</table>
</td></tr></table>

<!-- table 1 end -->

<br/><br/><br/>


<center>
<table border="0" cellpadding="4" cellspacing="0" width="980">
<tr><td width="100%" bgcolor="#7799BB" align="center">
<span style="font-family:Verdana; font-size:9pt; color:#FFFFFF">
<b>Share, NetBIOS, SNMP, Status, Misc</b>
</span></td></tr></table>
</center>
<br/>

<!-- table 2 start -->

<table bgcolor="#444444" border="0" cellpadding="0" cellspacing="0" width="980">
<tr><td>
<table border="0" cellpadding="2" cellspacing="1" width="100%">
<xsl:for-each select="address">
  <tr bgcolor="#BBDDFF">
  <td width="100%" colspan="5">

  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
    <td width="80%" class="tfont">

      <!-- insert bookmark for machine name -->
      <xsl:element name="a">
        <xsl:attribute name="name"><xsl:value-of select="position()"/></xsl:attribute>
      </xsl:element>
    
      <b>
        <xsl:choose>
        <xsl:when test="ip!=''">
          <xsl:value-of select="ip"/> [<xsl:value-of select="hostname"/>]
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="hostname"/>
        </xsl:otherwise>
        </xsl:choose>
      </b>
          
      </td>
      <td width="20%" align="right"><a href="#top"><font color="#666666">Top</font></a>&#160;&#160;</td>
    </tr>
  </table>
  </td></tr>

  <!-- share resource -->

  <xsl:if test="shareresource">
    <tr bgcolor="#FFFFFF">
    <xsl:element name="td">
      <xsl:attribute name="width">12%</xsl:attribute>
      <xsl:attribute name="class">tfont</xsl:attribute>
      <xsl:attribute name="rowspan"><xsl:value-of select="count(shareresource/share) + 1"/></xsl:attribute>
      <b>Shares - <xsl:value-of select="count(shareresource/share)"/></b>
    </xsl:element>
    <td width="20%" bgcolor="#E2E2E2"><b>Share Name</b></td>
    <td width="15%" bgcolor="#E2E2E2"><b>Type</b></td>
    <td width="15%" bgcolor="#E2E2E2"><b>Access</b></td>
    <td width="38%" bgcolor="#E2E2E2"><b>Remark</b></td>
    </tr>
    <xsl:for-each select="shareresource/share">
      <tr bgcolor="#FFFFFF">
      <td><xsl:value-of select="."/></td>
      <td><xsl:value-of select="@s_stype"/></td>
      <td><xsl:value-of select="@attrib"/></td>
      <td><xsl:value-of select="@comment"/></td>
      </tr>
    </xsl:for-each> 
  </xsl:if>

  <!-- NetBIOS name -->

  <xsl:if test="netbios">
    <tr bgcolor="#FFFFFF">
    <td width="12%" class="tfont"><b>NetBIOS - <xsl:value-of select="count(netbios/nbs)"/></b></td>
    <td width="88%" colspan="4">
    <xsl:for-each select="netbios/nbs">
      <xsl:value-of select="."/><br/>
    </xsl:for-each>
    </td></tr>
  </xsl:if>

  <!-- SNMP info -->

  <xsl:if test="snmp">
    <tr bgcolor="#FFFFFF">
    <td width="12%" class="tfont"><b>SNMP (system)</b></td>
    <td width="88%" colspan="4">
    <xsl:for-each select="snmp/*">

      <!-- sysUpTime shown in string -->
      <xsl:choose>
        <xsl:when test="name()='sysuptime'">
          <xsl:value-of select="name()"/> - <xsl:value-of select="@s"/><br/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="name()"/> - <xsl:value-of select="."/><br/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:for-each>
    </td></tr>
  </xsl:if>

  <!-- status -->

  <tr  bgcolor="#FFFFFF">
  <td width="12%" class="tfont"><b>Status</b></td>
  <td width="88%" colspan="4">
  <b>Current status</b> : <xsl:value-of select="status"/><br/>
  <xsl:if test="status/@status1">
    <b>Status 1</b> : <xsl:value-of select="status/@status1"/><br/>
    <b>Time 1</b> : <xsl:value-of select="status/@time1"/><br/>
  </xsl:if>
  <xsl:if test="status/@status2">
    <b>Status 2</b> : <xsl:value-of select="status/@status2"/><br/>
    <b>Time 2</b> : <xsl:value-of select="status/@time2"/><br/>
  </xsl:if>
  <xsl:if test="status/@status3">
  <b>Status 3</b> : <xsl:value-of select="status/@status3"/><br/>
  <b>Time 3</b> : <xsl:value-of select="status/@time3"/><br/>
  </xsl:if>
  <xsl:if test="status/@status4">
  <b>Status 4</b> : <xsl:value-of select="status/@status4"/><br/>
  <b>Time 4</b> : <xsl:value-of select="status/@time4"/><br/>
  </xsl:if>
  <xsl:if test="status/@status5">
  <b>Status 5</b> : <xsl:value-of select="status/@status5"/><br/>
  <b>Time 5</b> : <xsl:value-of select="status/@time5"/><br/>
  </xsl:if>
  </td></tr>

  <!-- other infomation -->

  <tr  bgcolor="#FFFFFF">
  <td width="12%" class="tfont"><b>Misc</b></td>
  <td width="88%" colspan="4">

  <xsl:choose>
  <xsl:when test="groups">
    <xsl:for-each select="groups/grp">
      <b>Group Name</b> : <xsl:value-of select="."/><br/>
    </xsl:for-each>
  </xsl:when>
  <xsl:otherwise>
    <b>Group Name</b> : <xsl:value-of select="group"/><br/>
  </xsl:otherwise>
  </xsl:choose>

  <b>NIC Vendor</b> : <xsl:value-of select="mac/@vendor"/><br/>
  <b>IP TTL</b> : <xsl:value-of select="ip/@ttl"/><br/>
  <b>IP Timeout</b> : <xsl:value-of select="ip/@time"/>
  </td></tr>
</xsl:for-each>
</table>
</td></tr></table>

<!-- table 2 end -->

<br/><br/>
</xsl:template>

</xsl:stylesheet>
