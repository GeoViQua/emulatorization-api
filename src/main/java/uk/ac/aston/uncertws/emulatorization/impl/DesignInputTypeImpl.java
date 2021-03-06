/*
 * XML Type:  DesignInputType
 * Namespace: http://uncertws.aston.ac.uk/emulatorization
 * Java type: uk.ac.aston.uncertws.emulatorization.DesignInputType
 *
 * Automatically generated - do not modify.
 */
package uk.ac.aston.uncertws.emulatorization.impl;
/**
 * An XML DesignInputType(@http://uncertws.aston.ac.uk/emulatorization).
 *
 * This is a complex type.
 */
public class DesignInputTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements uk.ac.aston.uncertws.emulatorization.DesignInputType
{
    private static final long serialVersionUID = 1L;
    
    public DesignInputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName IDENTIFIER$0 = 
        new javax.xml.namespace.QName("http://uncertws.aston.ac.uk/emulatorization", "identifier");
    private static final javax.xml.namespace.QName POINTS$2 = 
        new javax.xml.namespace.QName("http://uncertws.aston.ac.uk/emulatorization", "points");
    private static final javax.xml.namespace.QName MEAN$4 = 
        new javax.xml.namespace.QName("http://uncertws.aston.ac.uk/emulatorization", "mean");
    private static final javax.xml.namespace.QName STDDEV$6 = 
        new javax.xml.namespace.QName("http://uncertws.aston.ac.uk/emulatorization", "stdDev");
    
    
    /**
     * Gets the "identifier" element
     */
    public java.lang.String getIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "identifier" element
     */
    public org.apache.xmlbeans.XmlString xgetIdentifier()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "identifier" element
     */
    public void setIdentifier(java.lang.String identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IDENTIFIER$0);
            }
            target.setStringValue(identifier);
        }
    }
    
    /**
     * Sets (as xml) the "identifier" element
     */
    public void xsetIdentifier(org.apache.xmlbeans.XmlString identifier)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IDENTIFIER$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IDENTIFIER$0);
            }
            target.set(identifier);
        }
    }
    
    /**
     * Gets the "points" element
     */
    public java.util.List getPoints()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getListValue();
        }
    }
    
    /**
     * Gets (as xml) the "points" element
     */
    public uk.ac.aston.uncertws.emulatorization.DesignInputType.Points xgetPoints()
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.ac.aston.uncertws.emulatorization.DesignInputType.Points target = null;
            target = (uk.ac.aston.uncertws.emulatorization.DesignInputType.Points)get_store().find_element_user(POINTS$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "points" element
     */
    public void setPoints(java.util.List points)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(POINTS$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(POINTS$2);
            }
            target.setListValue(points);
        }
    }
    
    /**
     * Sets (as xml) the "points" element
     */
    public void xsetPoints(uk.ac.aston.uncertws.emulatorization.DesignInputType.Points points)
    {
        synchronized (monitor())
        {
            check_orphaned();
            uk.ac.aston.uncertws.emulatorization.DesignInputType.Points target = null;
            target = (uk.ac.aston.uncertws.emulatorization.DesignInputType.Points)get_store().find_element_user(POINTS$2, 0);
            if (target == null)
            {
                target = (uk.ac.aston.uncertws.emulatorization.DesignInputType.Points)get_store().add_element_user(POINTS$2);
            }
            target.set(points);
        }
    }
    
    /**
     * Gets the "mean" element
     */
    public double getMean()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MEAN$4, 0);
            if (target == null)
            {
                return 0.0;
            }
            return target.getDoubleValue();
        }
    }
    
    /**
     * Gets (as xml) the "mean" element
     */
    public org.apache.xmlbeans.XmlDouble xgetMean()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDouble target = null;
            target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(MEAN$4, 0);
            return target;
        }
    }
    
    /**
     * True if has "mean" element
     */
    public boolean isSetMean()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(MEAN$4) != 0;
        }
    }
    
    /**
     * Sets the "mean" element
     */
    public void setMean(double mean)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(MEAN$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(MEAN$4);
            }
            target.setDoubleValue(mean);
        }
    }
    
    /**
     * Sets (as xml) the "mean" element
     */
    public void xsetMean(org.apache.xmlbeans.XmlDouble mean)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDouble target = null;
            target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(MEAN$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(MEAN$4);
            }
            target.set(mean);
        }
    }
    
    /**
     * Unsets the "mean" element
     */
    public void unsetMean()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(MEAN$4, 0);
        }
    }
    
    /**
     * Gets the "stdDev" element
     */
    public double getStdDev()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STDDEV$6, 0);
            if (target == null)
            {
                return 0.0;
            }
            return target.getDoubleValue();
        }
    }
    
    /**
     * Gets (as xml) the "stdDev" element
     */
    public org.apache.xmlbeans.XmlDouble xgetStdDev()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDouble target = null;
            target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(STDDEV$6, 0);
            return target;
        }
    }
    
    /**
     * True if has "stdDev" element
     */
    public boolean isSetStdDev()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(STDDEV$6) != 0;
        }
    }
    
    /**
     * Sets the "stdDev" element
     */
    public void setStdDev(double stdDev)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STDDEV$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STDDEV$6);
            }
            target.setDoubleValue(stdDev);
        }
    }
    
    /**
     * Sets (as xml) the "stdDev" element
     */
    public void xsetStdDev(org.apache.xmlbeans.XmlDouble stdDev)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDouble target = null;
            target = (org.apache.xmlbeans.XmlDouble)get_store().find_element_user(STDDEV$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDouble)get_store().add_element_user(STDDEV$6);
            }
            target.set(stdDev);
        }
    }
    
    /**
     * Unsets the "stdDev" element
     */
    public void unsetStdDev()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(STDDEV$6, 0);
        }
    }
    /**
     * An XML points(@http://uncertws.aston.ac.uk/emulatorization).
     *
     * This is a list type whose items are org.apache.xmlbeans.XmlDouble.
     */
    public static class PointsImpl extends org.apache.xmlbeans.impl.values.XmlListImpl implements uk.ac.aston.uncertws.emulatorization.DesignInputType.Points
    {
        private static final long serialVersionUID = 1L;
        
        public PointsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected PointsImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}
