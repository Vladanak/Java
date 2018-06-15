<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html"/>
    <xsl:template match="airlist">
        <airlist>
            <xsl:apply-templates>
                <xsl:sort select="countPassengers" order="descending"/>
            </xsl:apply-templates>
        </airlist>
    </xsl:template>
    <xsl:template match="/airlist/air">
        <air>
            <xsl:for-each select="*">
                <xsl:attribute name="{name()}">
                    <xsl:value-of select="text()"/>
                </xsl:attribute>
            </xsl:for-each>
        </air>
    </xsl:template>

</xsl:stylesheet>