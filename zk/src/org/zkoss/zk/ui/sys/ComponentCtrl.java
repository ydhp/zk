/* ComponentCtrl.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon May 30 21:06:56     2005, Created by tomyeh
}}IS_NOTE

Copyright (C) 2005 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zk.ui.sys;

import java.util.List;
import java.util.Collection;

import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.metainfo.Milieu;
import org.zkoss.zk.ui.metainfo.Annotation;

/**
 * An addition interface to {@link org.zkoss.zk.ui.Component}
 * that is used for implementation or tools.
 *
 * <p>Application developers rarely need to access methods in this interface.
 *
 * @author tomyeh
 */
public interface ComponentCtrl {
	/** Returns the millieu of this component (never null).
	 */
	public Milieu getMilieu();

	/** Returns the annotation associated with the component,
	 * or null if not available.
	 *
	 * @param annotName the annotation name
	 */
	public Annotation getAnnotation(String annotName);
	/** Returns the annotation associated with the definition of the specified
	 * property, or null if not available.
	 *
	 * @param annotName the annotation name
	 * @param propName the property name, e.g., "value".
	 * @exception IllegalArgumentException if propName is null or empty
	 */
	public Annotation getAnnotation(String propName, String annotName);
	/** Returns a read-only collection of all annotations associated with this
	 * component (never null).
	 */
	public Collection getAnnotations();
	/** Returns a read-only collection of all annotations associated with the
	 * specified property (never null).
	 *
	 * @param propName the property name, e.g., "value".
	 * @exception IllegalArgumentException if propName is null or empty
	 */
	public Collection getAnnotations(String propName);
	/** Returns a read-only list of the names (String) of the properties
	 * that are associated with the specified annotation (never null).
	 */
	public List getAnnotatedPropertiesBy(String annotName);
	/** Returns a read-only list of the name (String) of properties that
	 * are associated at least one annotation (never null).
	 */
	public List getAnnotatedProperties();
	/** Associates an annotation to this component.
	 *
	 * <p>Unlike Java, you can add annotations dynamically, and each component
	 * has its own annotations.
	 */
	public void addAnnotation(Annotation annot);
	/** Adds an annotation to the specified proeprty of this component.
	 *
	 * @param propName the property name.
	 * @param annot the annotation.
	 */
	public void addAnnotation(String propName, Annotation annot);

	/** Notification that the session, which owns this component,
	 * is about to be passivated (aka., serialized).
	 *
	 * <p>Note: only root components are notified by this method.
	 */
	public void sessionWillPassivate(Page page);
	/** Notification that the session, which owns this component,
	 * has just been activated (aka., deserialized).
	 *
	 * <p>Note: only root components are notified by this method.
	 */
	public void sessionDidActivate(Page page);

	/** Returns the extra controls that tell ZK how to handle this component
	 * specially.
	 *
	 * <p>Application developers need NOT to access this method.
	 *
	 * <p>There are two set of extra controls: org.zkoss.zk.ui.ext.client
	 * and org.zkoss.zk.ui.ext.render.
	 *
	 * <p>The first package is used if the content of a component can be changed
	 * by the user at the client. It is so-called the client controls.
	 *
	 * <p>The second package is used to control how to render a component
	 * specially.
	 *
	 * <p>Override this method only if you want to return the extra
	 * controls.
	 *
	 * @return null if no special handling required. If the component
	 * requires some special controls, it could return an object that
	 * implements one or several interfaces in the org.zkoss.zk.ui.ext.render
	 * and org.zkoss.zk.ui.ext.client packages.
	 * For example, {@link org.zkoss.zk.ui.ext.render.Cropper}
	 * and {@link org.zkoss.zk.ui.ext.client.Inputable}.
	 */
	public Object getExtraCtrl();
}
