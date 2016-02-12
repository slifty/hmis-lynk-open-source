<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0" 
				xmlns:hmis="http://www.hudhdx.info/Resources/Vendors/4_0/HUD_HMIS.xsd" 
				xmlns:vc="http://www.w3.org/2007/XMLSchema-versioning">

<xsl:output omit-xml-declaration="yes" indent="yes"/>

<xsl:variable name='newline'><xsl:text>
</xsl:text></xsl:variable>
<xsl:strip-space elements="*"/>
 <xsl:template match="node()|@*">
  <xsl:copy>
   <xsl:apply-templates select="node()|@*"/>
  </xsl:copy>
 </xsl:template>
 
  <xsl:template match="Column[@SourceColumn='hmis:FirstName']|hmis:FirstName" />
  <xsl:template match="Column[@SourceColumn='hmis:MiddleName']|hmis:MiddleName" />
  <xsl:template match="Column[@SourceColumn='hmis:LastName']|hmis:LastName" />
  <xsl:template match="Column[@SourceColumn='hmis:SSN']|hmis:SSN" />
  
 
</xsl:stylesheet>