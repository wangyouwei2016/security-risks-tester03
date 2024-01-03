package com.example.demo.owasp.a01_brokenAccessControl;

import java.io.File;

/**
 * 
 * https://cwe.mitre.org/data/definitions/22.html
 * CWE-22: Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal')
 * The product uses external input to construct a pathname that is intended to identify a file or directory that is located underneath a restricted parent directory, but the product does not properly neutralize special elements within the pathname that can cause the pathname to resolve to a location that is outside of the restricted directory.
 *An attacker could provide an input such as this:

(attack code)
 
   /safe_dir/../important.dat
   The software assumes that the path is valid because it starts with the "/safe_path/" sequence, but the "../" sequence will cause the program to delete the important.dat file in the parent directory
 *
 *
 */
public class ImproperLimitationPathname {
	public static void improperLimitationPathname(String filePath) {
		if (filePath.startsWith("/safe_dir/"))
		{
			File f = new File(filePath);
			f.delete();
		}
	}
}
