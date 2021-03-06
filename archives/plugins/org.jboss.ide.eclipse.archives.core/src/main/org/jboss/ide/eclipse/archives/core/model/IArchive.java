/*******************************************************************************
 * Copyright (c) 2007 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.ide.eclipse.archives.core.model;

import org.eclipse.core.runtime.IPath;

/**
 * <p>
 * This interface represents an archive definition.
 * An archive definition consists of a list of folders, filesets, and sub-packages
 * </p>
 *
 * @author <a href="marshall@jboss.org">Marshall Culpepper</a>
 * @author <a href="rob.stryker@redhat.com">Rob Stryker</a>
 * @version $Revision: 1939 $
 */
public interface IArchive extends INamedContainerArchiveNode {
	public static final String ATTRIBUTE_PREFIX = "org.jboss.ide.eclipse.archives.core.model.IPackage."; //$NON-NLS-1$
	public static final String PACKAGE_TYPE_ATTRIBUTE = ATTRIBUTE_PREFIX + "packageType"; //$NON-NLS-1$
	public static final String EXPLODED_ATTRIBUTE = ATTRIBUTE_PREFIX + "exploded"; //$NON-NLS-1$
	public static final String DESTINATION_ATTRIBUTE = ATTRIBUTE_PREFIX + "destination"; //$NON-NLS-1$
	public static final String IN_WORKSPACE_ATTRIBUTE = ATTRIBUTE_PREFIX + "inWorkspace"; //$NON-NLS-1$


	/**
	 * @return The package type of this package.
	 */
	public IArchiveType getArchiveType();

	/**
	 * return the raw string from the delegate even if the type is not found
	 * @return
	 */
	public String getArchiveTypeId();

	/**
	 * @return Whether or not this package will be build exploded, or as a directory instead of a ZIP/JAR
	 */
	public boolean isExploded();

	/**
	 * @return Whether or not this package is a "top-level" package
	 * aka, not a child of another folder or package
	 * IOW: The parent must be null or a model node
	 */
	public boolean isTopLevel();

	/**
	 * If this package is top-level, there are two types of destinations it can have.
	 * "Inside" the workspace, and "outside" the workspace.
	 * @return Whether or not the destination of this package is in the workspace
	 */
	public boolean isDestinationInWorkspace();

	/**
	 * Get The path to this package's output file.
	 * This path should be GLOBAL
	 * @return  the path
	 */
	public IPath getArchiveFilePath();

	/**
	 * Exactly as from the delegate
	 * @return
	 */
	public String getRawDestinationPath();

	/**
	 * Set the package type of this package
	 * @param type The package type
	 */
	public void setArchiveType(IArchiveType type);

	/**
	 * Set the package type via ID.
	 * @param type
	 */
	public void setArchiveType(String type);

	/**
	 * Set whether or not this package is generated as a folder
	 * @param exploded
	 */
	public void setExploded(boolean exploded);

	/**
	 * Sets the destination path for this package.
	 * In workspace paths are relative to workspace root.
	 * Out of workspace paths are file-system absolute
	 * @param path The path where this archive will be built.
	 */
	public void setDestinationPath (IPath path);

	/**
	 * Set's whether the destination is workspace relative or not
	 */
	public void setInWorkspace(boolean inWorkspace);

	/**
	 * Top level archives should return a list of actions which
	 * must be done before or after building this archive
	 * @return
	 */
	public IArchiveAction[] getActions();
	public IArchiveAction[] getPreActions();
	public IArchiveAction[] getPostActions();

}
