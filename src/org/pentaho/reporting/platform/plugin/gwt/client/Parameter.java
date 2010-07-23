package org.pentaho.reporting.platform.plugin.gwt.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Todo: Document me!
 * <p/>
 * Date: 22.07.2010
 * Time: 13:47:30
 *
 * @author Thomas Morgner.
 */
public class Parameter
{
  public static final String CORE_NAMESPACE =
      "http://reporting.pentaho.org/namespaces/engine/parameter-attributes/core";

  private ArrayList<ParameterSelection> selections;
  private String name;
  private HashMap<String, HashMap<String, String>> attributes;

  public Parameter(final String name)
  {
    this.name = name;
    this.selections = new ArrayList<ParameterSelection>();
    this.attributes = new HashMap<String, HashMap<String, String>>();
  }

  public void addSelection(final ParameterSelection selection)
  {
    this.selections.add(selection);
  }

  public boolean hasValues()
  {
    return selections.isEmpty() == false;
  }

  public void setAttribute(final String namespace, final String name, final String value)
  {
    HashMap<String, String> hashMap = attributes.get(namespace);
    if (hashMap == null)
    {
      hashMap = new HashMap<String, String>();
      attributes.put(namespace, hashMap);
    }
    hashMap.put(name, value);
  }

  public String getAttribute(final String namespace, final String name)
  {
    final HashMap<String, String> hashMap = attributes.get(namespace);
    if (hashMap == null)
    {
      return null;
    }
    return hashMap.get(name);
  }

  public String getName()
  {
    return name;
  }

  public String getLabel()
  {
    final String attribute = getAttribute(CORE_NAMESPACE, "label"); // NON-NLS
    if (ReportViewerUtil.isEmpty(attribute))
    {
      return name;
    }
    return attribute;
  }

  public String getTooltip()
  {
    return getAttribute(CORE_NAMESPACE, "tooltip"); // NON-NLS
  }

  public boolean isStrict()
  {
    return "true".equals(getAttribute(CORE_NAMESPACE, "is-strict")); // NON-NLS
  }

  public boolean isMultiSelect()
  {
    return "true".equals(getAttribute(CORE_NAMESPACE, "is-multi-select")); // NON-NLS
  }

  public boolean isMandatory()
  {
    return "true".equals(getAttribute(CORE_NAMESPACE, "is-mandatory")); // NON-NLS
  }

  public String getAttribute(final String name)
  {
    return getAttribute(CORE_NAMESPACE, name);
  }

  public List<ParameterSelection> getSelections()
  {
    return selections;
  }

  public boolean isHidden()
  {
    // todo
    return false;
  }
}
