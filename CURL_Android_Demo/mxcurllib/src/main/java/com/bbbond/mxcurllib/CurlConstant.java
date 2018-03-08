package com.bbbond.mxcurllib;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bbbond on 2018/2/28.
 */

public class CurlConstant {
  private CurlConstant() {
  }

  private static Set<Integer> LONG_OPT_SET = new HashSet<Integer>();
  private static Set<Integer> OBJECT_POINT_OPT_SET = new HashSet<Integer>();
  private static Set<Integer> STRING_POINT_OPT_SET = new HashSet<Integer>();
  private static Set<Integer> FUNCTION_POINT_OPT_SET = new HashSet<Integer>();

  public static int CURLOPTTYPE_LONG = 0;
  public static int CURLOPTTYPE_OBJECTPOINT = 10000;
  public static int CURLOPTTYPE_STRINGPOINT = 10000;
  public static int CURLOPTTYPE_FUNCTIONPOINT = 20000;
  public static int CURLOPTTYPE_OFF_T = 30000;

  public static int CURLOPT_WRITEDATA = CURLOPTTYPE_OBJECTPOINT + 1;

  /* The full URL to get/put */
  public static int CURLOPT_URL = CURLOPTTYPE_STRINGPOINT + 2;

  /* Port number to connect to, if other than default. */
  public static int CURLOPT_PORT = CURLOPTTYPE_LONG + 3;

  /* Name of proxy to use. */
  public static int CURLOPT_PROXY = CURLOPTTYPE_STRINGPOINT + 4;

  /* "user:password;options" to use when fetching. */
  public static int CURLOPT_USERPWD = CURLOPTTYPE_STRINGPOINT + 5;

  /* "user:password" to use with proxy. */
  public static int CURLOPT_PROXYUSERPWD = CURLOPTTYPE_STRINGPOINT + 6;

  /* Range to get, specified as an ASCII string. */
  public static int CURLOPT_RANGE = CURLOPTTYPE_STRINGPOINT + 7;

  /* not used */

  /* Specified file stream to upload from (use as input): */
  public static int CURLOPT_READDATA = CURLOPTTYPE_OBJECTPOINT + 9;

  /* Buffer to receive error messages in, must be at least CURL_ERROR_SIZE
   * bytes big. If this is not used, error messages go to stderr instead: */
  public static int CURLOPT_ERRORBUFFER = CURLOPTTYPE_OBJECTPOINT + 10;

  /* Function that will be called to store the output (instead of fwrite). The
   * parameters will use fwrite() syntax, make sure to follow them. */
  public static int CURLOPT_WRITEFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 11;

  /* Function that will be called to read the input (instead of fread). The
   * parameters will use fread() syntax, make sure to follow them. */
  public static int CURLOPT_READFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 12;

  /* Time-out the read operation after this amount of seconds */
  public static int CURLOPT_TIMEOUT = CURLOPTTYPE_LONG + 13;

  /* If the CURLOPT_INFILE is used, this can be used to inform libcurl about
   * how large the file being sent really is. That allows better error
   * checking and better verifies that the upload was successful. -1 means
   * unknown size.
   *
   * For large file support, there is also a _LARGE version of the key
   * which takes an off_t type, allowing platforms with larger off_t
   * sizes to handle larger files.  See below for INFILESIZE_LARGE.
   */
  public static int CURLOPT_INFILESIZE = CURLOPTTYPE_LONG + 14;

  /* POST static input fields. */
  public static int CURLOPT_POSTFIELDS = CURLOPTTYPE_OBJECTPOINT + 15;

  /* Set the referrer page (needed by some CGIs) */
  public static int CURLOPT_REFERER = CURLOPTTYPE_STRINGPOINT + 16;

  /* Set the FTP PORT string (interface name, named or numerical IP address)
     Use i.e '-' to use default address. */
  public static int CURLOPT_FTPPORT = CURLOPTTYPE_STRINGPOINT + 17;

  /* Set the User-Agent string (examined by some CGIs) */
  public static int CURLOPT_USERAGENT = CURLOPTTYPE_STRINGPOINT + 18;

  /* If the download receives less than "low speed limit" bytes/second
   * during "low speed time" seconds, the operations is aborted.
   * You could i.e if you have a pretty high speed connection, abort if
   * it is less than 2000 bytes/sec during 20 seconds.
   */

  /* Set the "low speed limit" */
  public static int CURLOPT_LOW_SPEED_LIMIT = CURLOPTTYPE_LONG + 19;

  /* Set the "low speed time" */
  public static int CURLOPT_LOW_SPEED_TIME = CURLOPTTYPE_LONG + 20;

  /* Set the continuation offset.
   *
   * Note there is also a _LARGE version of this key which uses
   * off_t types, allowing for large file offsets on platforms which
   * use larger-than-32-bit off_t's.  Look below for RESUME_FROM_LARGE.
   */
  public static int CURLOPT_RESUME_FROM = CURLOPTTYPE_LONG + 21;

  /* Set cookie in request: */
  public static int CURLOPT_COOKIE = CURLOPTTYPE_STRINGPOINT + 22;

  /* This points to a linked list of headers, struct curl_slist kind. This
     list is also used for RTSP (in spite of its name) */
  public static int CURLOPT_HTTPHEADER = CURLOPTTYPE_OBJECTPOINT + 23;

  /* This points to a linked list of post entries, struct curl_httppost */
  public static int CURLOPT_HTTPPOST = CURLOPTTYPE_OBJECTPOINT + 24;

  /* name of the file keeping your private SSL-certificate */
  public static int CURLOPT_SSLCERT = CURLOPTTYPE_STRINGPOINT + 25;

  /* password for the SSL or SSH private key */
  public static int CURLOPT_KEYPASSWD = CURLOPTTYPE_STRINGPOINT + 26;

  /* send TYPE parameter? */
  public static int CURLOPT_CRLF = CURLOPTTYPE_LONG + 27;

  /* send linked-list of QUOTE commands */
  public static int CURLOPT_QUOTE = CURLOPTTYPE_OBJECTPOINT + 28;

  /* send FILE * or void * to store headers to, if you use a callback it
     is simply passed to the callback unmodified */
  public static int CURLOPT_HEADERDATA = CURLOPTTYPE_OBJECTPOINT + 29;

  /* point to a file to read the initial cookies from, also enables
     "cookie awareness" */
  public static int CURLOPT_COOKIEFILE = CURLOPTTYPE_STRINGPOINT + 31;

  /* What version to specifically try to use.
     See CURL_SSLVERSION defines below. */
  public static int CURLOPT_SSLVERSION = CURLOPTTYPE_LONG + 32;

  /* What kind of HTTP time condition to use, see defines */
  public static int CURLOPT_TIMECONDITION = CURLOPTTYPE_LONG + 33;

  /* Time to use with the above condition. Specified in number of seconds
     since 1 Jan 1970 */
  public static int CURLOPT_TIMEVALUE = CURLOPTTYPE_LONG + 34;

  /* 35 = OBSOLETE */

  /* Custom request, for customizing the get command like
     HTTP: DELETE, TRACE and others
     FTP: to use a different list command
     */
  public static int CURLOPT_CUSTOMREQUEST = CURLOPTTYPE_STRINGPOINT + 36;

  /* FILE handle to use instead of stderr */
  public static int CURLOPT_STDERR = CURLOPTTYPE_OBJECTPOINT + 37;

  /* 38 is not used */

  /* send linked-list of post-transfer QUOTE commands */
  public static int CURLOPT_POSTQUOTE = CURLOPTTYPE_OBJECTPOINT + 39;

  public static int CURLOPT_OBSOLETE40 = CURLOPTTYPE_OBJECTPOINT + 40; /* OBSOLETE, do not use! */

  public static int CURLOPT_VERBOSE = CURLOPTTYPE_LONG + 41;      /* talk a lot */
  public static int CURLOPT_HEADER = CURLOPTTYPE_LONG + 42;       /* throw the header out too */
  public static int CURLOPT_NOPROGRESS = CURLOPTTYPE_LONG + 43;   /* shut off the progress meter */
  public static int CURLOPT_NOBODY = CURLOPTTYPE_LONG + 44;       /* use HEAD to get http document */
  public static int CURLOPT_FAILONERROR = CURLOPTTYPE_LONG + 45;  /* no output on http error codes >= 400 */
  public static int CURLOPT_UPLOAD = CURLOPTTYPE_LONG + 46;       /* this is an upload */
  public static int CURLOPT_POST = CURLOPTTYPE_LONG + 47;         /* HTTP POST method */
  public static int CURLOPT_DIRLISTONLY = CURLOPTTYPE_LONG + 48;  /* bare names when listing directories */

  public static int CURLOPT_APPEND = CURLOPTTYPE_LONG + 50;       /* Append instead of overwrite on upload! */

  /* Specify whether to read the user+password from the .netrc or the URL.
   * This must be one of the CURL_NETRC_* enums below. */
  public static int CURLOPT_NETRC = CURLOPTTYPE_LONG + 51;

  public static int CURLOPT_FOLLOWLOCATION = CURLOPTTYPE_LONG + 52;  /* use Location: Luke! */

  public static int CURLOPT_TRANSFERTEXT = CURLOPTTYPE_LONG + 53; /* transfer data in text/ASCII format */
  public static int CURLOPT_PUT = CURLOPTTYPE_LONG + 54;          /* HTTP PUT */

  /* 55 = OBSOLETE */

  /* DEPRECATED
   * Function that will be called instead of the internal progress display
   * function. This function should be defined as the curl_progress_callback
   * prototype defines. */
  public static int CURLOPT_PROGRESSFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 56;

  /* Data passed to the CURLOPT_PROGRESSFUNCTION and CURLOPT_XFERINFOFUNCTION
     callbacks */
  public static int CURLOPT_PROGRESSDATA = CURLOPTTYPE_OBJECTPOINT + 57;
  public static int CURLOPT_XFERINFODATA = CURLOPT_PROGRESSDATA;

  /* We want the referrer field set automatically when following locations */
  public static int CURLOPT_AUTOREFERER = CURLOPTTYPE_LONG + 58;

  /* Port of the proxy, can be set in the proxy string as well with:
     "[host]:[port]" */
  public static int CURLOPT_PROXYPORT = CURLOPTTYPE_LONG + 59;

  /* size of the POST input data, if strlen() is not good to use */
  public static int CURLOPT_POSTFIELDSIZE = CURLOPTTYPE_LONG + 60;

  /* tunnel non-http operations through a HTTP proxy */
  public static int CURLOPT_HTTPPROXYTUNNEL = CURLOPTTYPE_LONG + 61;

  /* Set the interface string to use as outgoing network interface */
  public static int CURLOPT_INTERFACE = CURLOPTTYPE_STRINGPOINT + 62;

  /* Set the krb4/5 security level, this also enables krb4/5 awareness.  This
   * is a string, 'clear', 'safe', 'confidential' or 'private'.  If the string
   * is set but doesn't match one of these, 'private' will be used.  */
  public static int CURLOPT_KRBLEVEL = CURLOPTTYPE_STRINGPOINT + 63;

  /* Set if we should verify the peer in ssl handshake, set 1 to verify. */
  public static int CURLOPT_SSL_VERIFYPEER = CURLOPTTYPE_LONG + 64;

  /* The CApath or CAfile used to validate the peer certificate
     this option is used only if SSL_VERIFYPEER is true */
  public static int CURLOPT_CAINFO = CURLOPTTYPE_STRINGPOINT + 65;

  /* 66 = OBSOLETE */
  /* 67 = OBSOLETE */

  /* Maximum number of http redirects to follow */
  public static int CURLOPT_MAXREDIRS = CURLOPTTYPE_LONG + 68;

  /* Pass a long set to 1 to get the date of the requested document (if
     possible)! Pass a zero to shut it off. */
  public static int CURLOPT_FILETIME = CURLOPTTYPE_LONG + 69;

  /* This points to a linked list of telnet options */
  public static int CURLOPT_TELNETOPTIONS = CURLOPTTYPE_OBJECTPOINT + 70;

  /* Max amount of cached alive connections */
  public static int CURLOPT_MAXCONNECTS = CURLOPTTYPE_LONG + 71;

  public static int CURLOPT_OBSOLETE72 = CURLOPTTYPE_LONG + 72; /* OBSOLETE, do not use! */

  /* 73 = OBSOLETE */

  /* Set to explicitly use a new connection for the upcoming transfer.
     Do not use this unless you're absolutely sure of this, as it makes the
     operation slower and is less friendly for the network. */
  public static int CURLOPT_FRESH_CONNECT = CURLOPTTYPE_LONG + 74;

  /* Set to explicitly forbid the upcoming transfer's connection to be re-used
     when done. Do not use this unless you're absolutely sure of this, as it
     makes the operation slower and is less friendly for the network. */
  public static int CURLOPT_FORBID_REUSE = CURLOPTTYPE_LONG + 75;

  /* Set to a file name that contains random data for libcurl to use to
     seed the random engine when doing SSL connects. */
  public static int CURLOPT_RANDOM_FILE = CURLOPTTYPE_STRINGPOINT + 76;

  /* Set to the Entropy Gathering Daemon socket pathname */
  public static int CURLOPT_EGDSOCKET = CURLOPTTYPE_STRINGPOINT + 77;

  /* Time-out connect operations after this amount of seconds, if connects are
     OK within this time, then fine... This only aborts the connect phase. */
  public static int CURLOPT_CONNECTTIMEOUT = CURLOPTTYPE_LONG + 78;

  /* Function that will be called to store headers (instead of fwrite). The
   * parameters will use fwrite() syntax, make sure to follow them. */
  public static int CURLOPT_HEADERFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 79;

  /* Set this to force the HTTP request to get back to GET. Only really usable
     if POST + PUT or a custom request have been used first.
   */
  public static int CURLOPT_HTTPGET = CURLOPTTYPE_LONG + 80;

  /* Set if we should verify the Common name from the peer certificate in ssl
   * handshake, set 1 to check existence, 2 to ensure that it matches the
   * provided hostname. */
  public static int CURLOPT_SSL_VERIFYHOST = CURLOPTTYPE_LONG + 81;

  /* Specify which file name to write all known cookies in after completed
     operation. Set file name to "-" (dash) to make it go to stdout. */
  public static int CURLOPT_COOKIEJAR = CURLOPTTYPE_STRINGPOINT + 82;

  /* Specify which SSL ciphers to use */
  public static int CURLOPT_SSL_CIPHER_LIST = CURLOPTTYPE_STRINGPOINT + 83;

  /* Specify which HTTP version to use! This must be set to one of the
     CURL_HTTP_VERSION* enums set below. */
  public static int CURLOPT_HTTP_VERSION = CURLOPTTYPE_LONG + 84;

  /* Specifically switch on or off the FTP engine's use of the EPSV command. By
     default, that one will always be attempted before the more traditional
     PASV command. */
  public static int CURLOPT_FTP_USE_EPSV = CURLOPTTYPE_LONG + 85;

  /* type of the file keeping your SSL-certificate ("DER", "PEM", "ENG") */
  public static int CURLOPT_SSLCERTTYPE = CURLOPTTYPE_STRINGPOINT + 86;

  /* name of the file keeping your private SSL-key */
  public static int CURLOPT_SSLKEY = CURLOPTTYPE_STRINGPOINT + 87;

  /* type of the file keeping your private SSL-key ("DER", "PEM", "ENG") */
  public static int CURLOPT_SSLKEYTYPE = CURLOPTTYPE_STRINGPOINT + 88;

  /* crypto engine for the SSL-sub system */
  public static int CURLOPT_SSLENGINE = CURLOPTTYPE_STRINGPOINT + 89;

  /* set the crypto engine for the SSL-sub system as default
     the param has no meaning...
   */
  public static int CURLOPT_SSLENGINE_DEFAULT = CURLOPTTYPE_LONG + 90;

  /* Non-zero value means to use the global dns cache */
  public static int CURLOPT_DNS_USE_GLOBAL_CACHE = CURLOPTTYPE_LONG + 91; /* DEPRECATED, do not use! */

  /* DNS cache timeout */
  public static int CURLOPT_DNS_CACHE_TIMEOUT = CURLOPTTYPE_LONG + 92;

  /* send linked-list of pre-transfer QUOTE commands */
  public static int CURLOPT_PREQUOTE = CURLOPTTYPE_OBJECTPOINT + 93;

  /* set the debug function */
  public static int CURLOPT_DEBUGFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 94;

  /* set the data for the debug function */
  public static int CURLOPT_DEBUGDATA = CURLOPTTYPE_OBJECTPOINT + 95;

  /* mark this as start of a cookie session */
  public static int CURLOPT_COOKIESESSION = CURLOPTTYPE_LONG + 96;

  /* The CApath directory used to validate the peer certificate
     this option is used only if SSL_VERIFYPEER is true */
  public static int CURLOPT_CAPATH = CURLOPTTYPE_STRINGPOINT + 97;

  /* Instruct libcurl to use a smaller receive buffer */
  public static int CURLOPT_BUFFERSIZE = CURLOPTTYPE_LONG + 98;

  /* Instruct libcurl to not use any signal/alarm handlers, even when using
     timeouts. This option is useful for multi-threaded applications.
     See libcurl-the-guide for more background information. */
  public static int CURLOPT_NOSIGNAL = CURLOPTTYPE_LONG + 99;

  /* Provide a CURLShare for mutexing non-ts data */
  public static int CURLOPT_SHARE = CURLOPTTYPE_OBJECTPOINT + 100;

  /* indicates type of proxy. accepted values are CURLPROXY_HTTP (default;
     CURLPROXY_HTTPS, CURLPROXY_SOCKS4, CURLPROXY_SOCKS4A and
     CURLPROXY_SOCKS5. */
  public static int CURLOPT_PROXYTYPE = CURLOPTTYPE_LONG + 101;

  /* Set the Accept-Encoding string. Use this to tell a server you would like
     the response to be compressed. Before 7.21.6, this was known as
     CURLOPT_ENCODING */
  public static int CURLOPT_ACCEPT_ENCODING = CURLOPTTYPE_STRINGPOINT + 102;

  /* Set pointer to private data */
  public static int CURLOPT_PRIVATE = CURLOPTTYPE_OBJECTPOINT + 103;

  /* Set aliases for HTTP 200 in the HTTP Response header */
  public static int CURLOPT_HTTP200ALIASES = CURLOPTTYPE_OBJECTPOINT + 104;

  /* Continue to send authentication (user+password) when following locations,
     even when hostname changed. This can potentially send off the name
     and password to whatever host the server decides. */
  public static int CURLOPT_UNRESTRICTED_AUTH = CURLOPTTYPE_LONG + 105;

  /* Specifically switch on or off the FTP engine's use of the EPRT command (
     it also disables the LPRT attempt). By default, those ones will always be
     attempted before the good old traditional PORT command. */
  public static int CURLOPT_FTP_USE_EPRT = CURLOPTTYPE_LONG + 106;

  /* Set this to a bitmask value to enable the particular authentications
     methods you like. Use this in combination with CURLOPT_USERPWD.
     Note that setting multiple bits may cause extra network round-trips. */
  public static int CURLOPT_HTTPAUTH = CURLOPTTYPE_LONG + 107;

  /* Set the ssl context callback function, currently only for OpenSSL ssl_ctx
     in second argument. The function must be matching the
     curl_ssl_ctx_callback proto. */
  public static int CURLOPT_SSL_CTX_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 108;

  /* Set the userdata for the ssl context callback function's third
     argument */
  public static int CURLOPT_SSL_CTX_DATA = CURLOPTTYPE_OBJECTPOINT + 109;

  /* FTP Option that causes missing dirs to be created on the remote server.
     In 7.19.4 we introduced the convenience enums for this option using the
     CURLFTP_CREATE_DIR prefix.
  */
  public static int CURLOPT_FTP_CREATE_MISSING_DIRS = CURLOPTTYPE_LONG + 110;

  /* Set this to a bitmask value to enable the particular authentications
     methods you like. Use this in combination with CURLOPT_PROXYUSERPWD.
     Note that setting multiple bits may cause extra network round-trips. */
  public static int CURLOPT_PROXYAUTH = CURLOPTTYPE_LONG + 111;

  /* FTP option that changes the timeout, in seconds, associated with
     getting a response.  This is different from transfer timeout time and
     essentially places a demand on the FTP server to acknowledge commands
     in a timely manner. */
  public static int CURLOPT_FTP_RESPONSE_TIMEOUT = CURLOPTTYPE_LONG + 112;
  public static int CURLOPT_SERVER_RESPONSE_TIMEOUT = CURLOPT_FTP_RESPONSE_TIMEOUT;

  /* Set this option to one of the CURL_IPRESOLVE_* defines (see below) to
     tell libcurl to resolve names to those IP versions only. This only has
     affect on systems with support for more than one, i.e IPv4 _and_ IPv6. */
  public static int CURLOPT_IPRESOLVE = CURLOPTTYPE_LONG + 113;

  /* Set this option to limit the size of a file that will be downloaded from
     an HTTP or FTP server.

     Note there is also _LARGE version which adds large file support for
     platforms which have larger off_t sizes.  See MAXFILESIZE_LARGE below. */
  public static int CURLOPT_MAXFILESIZE = CURLOPTTYPE_LONG + 114;

  /* See the comment for INFILESIZE above, but in short, specifies
   * the size of the file being uploaded.  -1 means unknown.
   */
  public static int CURLOPT_INFILESIZE_LARGE = CURLOPTTYPE_OFF_T + 115;

  /* Sets the continuation offset.  There is also a LONG version of this;
   * look above for RESUME_FROM.
   */
  public static int CURLOPT_RESUME_FROM_LARGE = CURLOPTTYPE_OFF_T + 116;

  /* Sets the maximum size of data that will be downloaded from
   * an HTTP or FTP server.  See MAXFILESIZE above for the LONG version.
   */
  public static int CURLOPT_MAXFILESIZE_LARGE = CURLOPTTYPE_OFF_T + 117;

  /* Set this option to the file name of your .netrc file you want libcurl
     to parse (using the CURLOPT_NETRC option). If not set, libcurl will do
     a poor attempt to find the user's home directory and check for a .netrc
     file in there. */
  public static int CURLOPT_NETRC_FILE = CURLOPTTYPE_STRINGPOINT + 118;

  /* Enable SSL/TLS for FTP, pick one of:
     CURLUSESSL_TRY     - try using SSL, proceed anyway otherwise
     CURLUSESSL_CONTROL - SSL for the control connection or fail
     CURLUSESSL_ALL     - SSL for all communication or fail
  */
  public static int CURLOPT_USE_SSL = CURLOPTTYPE_LONG + 119;

  /* The _LARGE version of the standard POSTFIELDSIZE option */
  public static int CURLOPT_POSTFIELDSIZE_LARGE = CURLOPTTYPE_OFF_T + 120;

  /* Enable/disable the TCP Nagle algorithm */
  public static int CURLOPT_TCP_NODELAY = CURLOPTTYPE_LONG + 121;

  /* 122 OBSOLETE, used in 7.12.3. Gone in 7.13.0 */
  /* 123 OBSOLETE. Gone in 7.16.0 */
  /* 124 OBSOLETE, used in 7.12.3. Gone in 7.13.0 */
  /* 125 OBSOLETE, used in 7.12.3. Gone in 7.13.0 */
  /* 126 OBSOLETE, used in 7.12.3. Gone in 7.13.0 */
  /* 127 OBSOLETE. Gone in 7.16.0 */
  /* 128 OBSOLETE. Gone in 7.16.0 */

  /* When FTP over SSL/TLS is selected (with CURLOPT_USE_SSL; this option
     can be used to change libcurl's default action which is to first try
     "AUTH SSL" and then "AUTH TLS" in this order, and proceed when a OK
     response has been received.

     Available parameters are:
     CURLFTPAUTH_DEFAULT - let libcurl decide
     CURLFTPAUTH_SSL     - try "AUTH SSL" first, then TLS
     CURLFTPAUTH_TLS     - try "AUTH TLS" first, then SSL
  */
  public static int CURLOPT_FTPSSLAUTH = CURLOPTTYPE_LONG + 129;

  public static int CURLOPT_IOCTLFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 130;
  public static int CURLOPT_IOCTLDATA = CURLOPTTYPE_OBJECTPOINT + 131;

  /* 132 OBSOLETE. Gone in 7.16.0 */
  /* 133 OBSOLETE. Gone in 7.16.0 */

  /* zero terminated string for pass on to the FTP server when asked for
     "account" info */
  public static int CURLOPT_FTP_ACCOUNT = CURLOPTTYPE_STRINGPOINT + 134;

  /* feed cookie into cookie engine */
  public static int CURLOPT_COOKIELIST = CURLOPTTYPE_STRINGPOINT + 135;

  /* ignore Content-Length */
  public static int CURLOPT_IGNORE_CONTENT_LENGTH = CURLOPTTYPE_LONG + 136;

  /* Set to non-zero to skip the IP address received in a 227 PASV FTP server
     response. Typically used for FTP-SSL purposes but is not restricted to
     that. libcurl will then instead use the same IP address it used for the
     control connection. */
  public static int CURLOPT_FTP_SKIP_PASV_IP = CURLOPTTYPE_LONG + 137;

  /* Select "file method" to use when doing FTP, see the curl_ftpmethod
     above. */
  public static int CURLOPT_FTP_FILEMETHOD = CURLOPTTYPE_LONG + 138;

  /* Local port number to bind the socket to */
  public static int CURLOPT_LOCALPORT = CURLOPTTYPE_LONG + 139;

  /* Number of ports to try, including the first one set with LOCALPORT.
     Thus, setting it to 1 will make no additional attempts but the first.
  */
  public static int CURLOPT_LOCALPORTRANGE = CURLOPTTYPE_LONG + 140;

  /* no transfer, set up connection and let application use the socket by
     extracting it with CURLINFO_LASTSOCKET */
  public static int CURLOPT_CONNECT_ONLY = CURLOPTTYPE_LONG + 141;

  /* Function that will be called to convert from the
     network encoding (instead of using the iconv calls in libcurl) */
  public static int CURLOPT_CONV_FROM_NETWORK_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 142;

  /* Function that will be called to convert to the
     network encoding (instead of using the iconv calls in libcurl) */
  public static int CURLOPT_CONV_TO_NETWORK_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 143;

  /* Function that will be called to convert from UTF8
     (instead of using the iconv calls in libcurl)
     Note that this is used only for SSL certificate processing */
  public static int CURLOPT_CONV_FROM_UTF8_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 144;

  /* if the connection proceeds too quickly then need to slow it down */
  /* limit-rate: maximum number of bytes per second to send or receive */
  public static int CURLOPT_MAX_SEND_SPEED_LARGE = CURLOPTTYPE_OFF_T + 145;
  public static int CURLOPT_MAX_RECV_SPEED_LARGE = CURLOPTTYPE_OFF_T + 146;

  /* Pointer to command string to send if USER/PASS fails. */
  public static int CURLOPT_FTP_ALTERNATIVE_TO_USER = CURLOPTTYPE_STRINGPOINT + 147;

  /* callback function for setting socket options */
  public static int CURLOPT_SOCKOPTFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 148;
  public static int CURLOPT_SOCKOPTDATA = CURLOPTTYPE_OBJECTPOINT + 149;

  /* set to 0 to disable session ID re-use for this transfer, default is
     enabled (== 1) */
  public static int CURLOPT_SSL_SESSIONID_CACHE = CURLOPTTYPE_LONG + 150;

  /* allowed SSH authentication methods */
  public static int CURLOPT_SSH_AUTH_TYPES = CURLOPTTYPE_LONG + 151;

  /* Used by scp/sftp to do public/private key authentication */
  public static int CURLOPT_SSH_PUBLIC_KEYFILE = CURLOPTTYPE_STRINGPOINT + 152;
  public static int CURLOPT_SSH_PRIVATE_KEYFILE = CURLOPTTYPE_STRINGPOINT + 153;

  /* Send CCC (Clear Command Channel) after authentication */
  public static int CURLOPT_FTP_SSL_CCC = CURLOPTTYPE_LONG + 154;

  /* Same as TIMEOUT and CONNECTTIMEOUT + but with ms resolution */
  public static int CURLOPT_TIMEOUT_MS = CURLOPTTYPE_LONG + 155;
  public static int CURLOPT_CONNECTTIMEOUT_MS = CURLOPTTYPE_LONG + 156;

  /* set to zero to disable the libcurl's decoding and thus pass the raw body
     data to the application even when it is encoded/compressed */
  public static int CURLOPT_HTTP_TRANSFER_DECODING = CURLOPTTYPE_LONG + 157;
  public static int CURLOPT_HTTP_CONTENT_DECODING = CURLOPTTYPE_LONG + 158;

  /* Permission used when creating new files and directories on the remote
     server for protocols that support it= CURLOPTTYPE_SFTP/SCP/FILE */
  public static int CURLOPT_NEW_FILE_PERMS = CURLOPTTYPE_LONG + 159;
  public static int CURLOPT_NEW_DIRECTORY_PERMS = CURLOPTTYPE_LONG + 160;

  /* Set the behaviour of POST when redirecting. Values must be set to one
     of CURL_REDIR* defines below. This used to be called CURLOPT_POST301 */
  public static int CURLOPT_POSTREDIR = CURLOPTTYPE_LONG + 161;

  /* used by scp/sftp to verify the host's public key */
  public static int CURLOPT_SSH_HOST_PUBLIC_KEY_MD5 = CURLOPTTYPE_STRINGPOINT + 162;

  /* Callback function for opening socket (instead of socket(2)). Optionally,
     callback is able change the address or refuse to connect returning
     CURL_SOCKET_BAD.  The callback should have type
     curl_opensocket_callback */
  public static int CURLOPT_OPENSOCKETFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 163;
  public static int CURLOPT_OPENSOCKETDATA = CURLOPTTYPE_OBJECTPOINT + 164;

  /* POST volatile input fields. */
  public static int CURLOPT_COPYPOSTFIELDS = CURLOPTTYPE_OBJECTPOINT + 165;

  /* set transfer mode (;type=<a|i>) when doing FTP via an HTTP proxy */
  public static int CURLOPT_PROXY_TRANSFER_MODE = CURLOPTTYPE_LONG + 166;

  /* Callback function for seeking in the input stream */
  public static int CURLOPT_SEEKFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 167;
  public static int CURLOPT_SEEKDATA = CURLOPTTYPE_OBJECTPOINT + 168;

  /* CRL file */
  public static int CURLOPT_CRLFILE = CURLOPTTYPE_STRINGPOINT + 169;

  /* Issuer certificate */
  public static int CURLOPT_ISSUERCERT = CURLOPTTYPE_STRINGPOINT + 170;

  /* (IPv6) Address scope */
  public static int CURLOPT_ADDRESS_SCOPE = CURLOPTTYPE_LONG + 171;

  /* Collect certificate chain info and allow it to get retrievable with
     CURLINFO_CERTINFO after the transfer is complete. */
  public static int CURLOPT_CERTINFO = CURLOPTTYPE_LONG + 172;

  /* "name" and "pwd" to use when fetching. */
  public static int CURLOPT_USERNAME = CURLOPTTYPE_STRINGPOINT + 173;
  public static int CURLOPT_PASSWORD = CURLOPTTYPE_STRINGPOINT + 174;

  /* "name" and "pwd" to use with Proxy when fetching. */
  public static int CURLOPT_PROXYUSERNAME = CURLOPTTYPE_STRINGPOINT + 175;
  public static int CURLOPT_PROXYPASSWORD = CURLOPTTYPE_STRINGPOINT + 176;

  /* Comma separated list of hostnames defining no-proxy zones. These should
     match both hostnames directly, and hostnames within a domain. For
     example, local.com will match local.com and www.local.com, but NOT
     notlocal.com or www.notlocal.com. For compatibility with other
     implementations of this, .local.com will be considered to be the same as
     local.com. A single * is the only valid wildcard, and effectively
     disables the use of proxy. */
  public static int CURLOPT_NOPROXY = CURLOPTTYPE_STRINGPOINT + 177;

  /* block size for TFTP transfers */
  public static int CURLOPT_TFTP_BLKSIZE = CURLOPTTYPE_LONG + 178;

  /* Socks Service */
  public static int CURLOPT_SOCKS5_GSSAPI_SERVICE = CURLOPTTYPE_STRINGPOINT + 179; /* DEPRECATED, do not use! */

  /* Socks Service */
  public static int CURLOPT_SOCKS5_GSSAPI_NEC = CURLOPTTYPE_LONG + 180;

  /* set the bitmask for the protocols that are allowed to be used for the
     transfer, which thus helps the app which takes URLs from users or other
     external inputs and want to restrict what protocol(s) to deal
     with. Defaults to CURLPROTO_ALL. */
  public static int CURLOPT_PROTOCOLS = CURLOPTTYPE_LONG + 181;

  /* set the bitmask for the protocols that libcurl is allowed to follow to,
     as a subset of the CURLOPT_PROTOCOLS ones. That means the protocol needs
     to be set in both bitmasks to be allowed to get redirected to. Defaults
     to all protocols except FILE and SCP. */
  public static int CURLOPT_REDIR_PROTOCOLS = CURLOPTTYPE_LONG + 182;

  /* set the SSH knownhost file name to use */
  public static int CURLOPT_SSH_KNOWNHOSTS = CURLOPTTYPE_STRINGPOINT + 183;

  /* set the SSH host key callback, must point to a curl_sshkeycallback
     function */
  public static int CURLOPT_SSH_KEYFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 184;

  /* set the SSH host key callback custom pointer */
  public static int CURLOPT_SSH_KEYDATA = CURLOPTTYPE_OBJECTPOINT + 185;

  /* set the SMTP mail originator */
  public static int CURLOPT_MAIL_FROM = CURLOPTTYPE_STRINGPOINT + 186;

  /* set the list of SMTP mail receiver(s) */
  public static int CURLOPT_MAIL_RCPT = CURLOPTTYPE_OBJECTPOINT + 187;

  /* FTP: send PRET before PASV */
  public static int CURLOPT_FTP_USE_PRET = CURLOPTTYPE_LONG + 188;

  /* RTSP request method (OPTIONS= CURLOPTTYPE_SETUP, PLAY, etc...) */
  public static int CURLOPT_RTSP_REQUEST = CURLOPTTYPE_LONG + 189;

  /* The RTSP session identifier */
  public static int CURLOPT_RTSP_SESSION_ID = CURLOPTTYPE_STRINGPOINT + 190;

  /* The RTSP stream URI */
  public static int CURLOPT_RTSP_STREAM_URI = CURLOPTTYPE_STRINGPOINT + 191;

  /* The Transport: header to use in RTSP requests */
  public static int CURLOPT_RTSP_TRANSPORT = CURLOPTTYPE_STRINGPOINT + 192;

  /* Manually initialize the client RTSP CSeq for this handle */
  public static int CURLOPT_RTSP_CLIENT_CSEQ = CURLOPTTYPE_LONG + 193;

  /* Manually initialize the server RTSP CSeq for this handle */
  public static int CURLOPT_RTSP_SERVER_CSEQ = CURLOPTTYPE_LONG + 194;

  /* The stream to pass to INTERLEAVEFUNCTION. */
  public static int CURLOPT_INTERLEAVEDATA = CURLOPTTYPE_OBJECTPOINT + 195;

  /* Let the application define a custom write method for RTP data */
  public static int CURLOPT_INTERLEAVEFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 196;

  /* Turn on wildcard matching */
  public static int CURLOPT_WILDCARDMATCH = CURLOPTTYPE_LONG + 197;

  /* Directory matching callback called before downloading of an
     individual file (chunk) started */
  public static int CURLOPT_CHUNK_BGN_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 198;

  /* Directory matching callback called after the file (chunk)
     was downloaded, or skipped */
  public static int CURLOPT_CHUNK_END_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 199;

  /* Change match (fnmatch-like) callback for wildcard matching */
  public static int CURLOPT_FNMATCH_FUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 200;

  /* Let the application define custom chunk data pointer */
  public static int CURLOPT_CHUNK_DATA = CURLOPTTYPE_OBJECTPOINT + 201;

  /* FNMATCH_FUNCTION user pointer */
  public static int CURLOPT_FNMATCH_DATA = CURLOPTTYPE_OBJECTPOINT + 202;

  /* send linked-list of name:port:address sets */
  public static int CURLOPT_RESOLVE = CURLOPTTYPE_OBJECTPOINT + 203;

  /* Set a username for authenticated TLS */
  public static int CURLOPT_TLSAUTH_USERNAME = CURLOPTTYPE_STRINGPOINT + 204;

  /* Set a password for authenticated TLS */
  public static int CURLOPT_TLSAUTH_PASSWORD = CURLOPTTYPE_STRINGPOINT + 205;

  /* Set authentication type for authenticated TLS */
  public static int CURLOPT_TLSAUTH_TYPE = CURLOPTTYPE_STRINGPOINT + 206;

  /* Set to 1 to enable the "TE:" header in HTTP requests to ask for
     compressed transfer-encoded responses. Set to 0 to disable the use of TE:
     in outgoing requests. The current default is 0, but it might change in a
     future libcurl release.

     libcurl will ask for the compressed methods it knows of, and if that
     isn't any, it will not ask for transfer-encoding at all even if this
     option is set to 1.

  */
  public static int CURLOPT_TRANSFER_ENCODING = CURLOPTTYPE_LONG + 207;

  /* Callback function for closing socket (instead of close(2)). The callback
     should have type curl_closesocket_callback */
  public static int CURLOPT_CLOSESOCKETFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 208;
  public static int CURLOPT_CLOSESOCKETDATA = CURLOPTTYPE_OBJECTPOINT + 209;

  /* allow GSSAPI credential delegation */
  public static int CURLOPT_GSSAPI_DELEGATION = CURLOPTTYPE_LONG + 210;

  /* Set the name servers to use for DNS resolution */
  public static int CURLOPT_DNS_SERVERS = CURLOPTTYPE_STRINGPOINT + 211;

  /* Time-out accept operations (currently for FTP only) after this amount
     of miliseconds. */
  public static int CURLOPT_ACCEPTTIMEOUT_MS = CURLOPTTYPE_LONG + 212;

  /* Set TCP keepalive */
  public static int CURLOPT_TCP_KEEPALIVE = CURLOPTTYPE_LONG + 213;

  /* non-universal keepalive knobs (Linux, AIX, HP-UX, more) */
  public static int CURLOPT_TCP_KEEPIDLE = CURLOPTTYPE_LONG + 214;
  public static int CURLOPT_TCP_KEEPINTVL = CURLOPTTYPE_LONG + 215;

  /* Enable/disable specific SSL features with a bitmask, see CURLSSLOPT_* */
  public static int CURLOPT_SSL_OPTIONS = CURLOPTTYPE_LONG + 216;

  /* Set the SMTP auth originator */
  public static int CURLOPT_MAIL_AUTH = CURLOPTTYPE_STRINGPOINT + 217;

  /* Enable/disable SASL initial response */
  public static int CURLOPT_SASL_IR = CURLOPTTYPE_LONG + 218;

  /* Function that will be called instead of the internal progress display
   * function. This function should be defined as the curl_xferinfo_callback
   * prototype defines. (Deprecates CURLOPT_PROGRESSFUNCTION) */
  public static int CURLOPT_XFERINFOFUNCTION = CURLOPTTYPE_FUNCTIONPOINT + 219;

  /* The XOAUTH2 bearer token */
  public static int CURLOPT_XOAUTH2_BEARER = CURLOPTTYPE_STRINGPOINT + 220;

  /* Set the interface string to use as outgoing network
   * interface for DNS requests.
   * Only supported by the c-ares DNS backend */
  public static int CURLOPT_DNS_INTERFACE = CURLOPTTYPE_STRINGPOINT + 221;

  /* Set the local IPv4 address to use for outgoing DNS requests.
   * Only supported by the c-ares DNS backend */
  public static int CURLOPT_DNS_LOCAL_IP4 = CURLOPTTYPE_STRINGPOINT + 222;

  /* Set the local IPv4 address to use for outgoing DNS requests.
   * Only supported by the c-ares DNS backend */
  public static int CURLOPT_DNS_LOCAL_IP6 = CURLOPTTYPE_STRINGPOINT + 223;

  /* Set authentication options directly */
  public static int CURLOPT_LOGIN_OPTIONS = CURLOPTTYPE_STRINGPOINT + 224;

  /* Enable/disable TLS NPN extension (http2 over ssl might fail without) */
  public static int CURLOPT_SSL_ENABLE_NPN = CURLOPTTYPE_LONG + 225;

  /* Enable/disable TLS ALPN extension (http2 over ssl might fail without) */
  public static int CURLOPT_SSL_ENABLE_ALPN = CURLOPTTYPE_LONG + 226;

  /* Time to wait for a response to a HTTP request containing an
   * Expect: 100-continue header before sending the data anyway. */
  public static int CURLOPT_EXPECT_100_TIMEOUT_MS = CURLOPTTYPE_LONG + 227;

  /* This points to a linked list of headers used for proxy requests only,
     struct curl_slist kind */
  public static int CURLOPT_PROXYHEADER = CURLOPTTYPE_OBJECTPOINT + 228;

  /* Pass in a bitmask of "header options" */
  public static int CURLOPT_HEADEROPT = CURLOPTTYPE_LONG + 229;

  /* The public key in DER form used to validate the peer public key
     this option is used only if SSL_VERIFYPEER is true */
  public static int CURLOPT_PINNEDPUBLICKEY = CURLOPTTYPE_STRINGPOINT + 230;

  /* Path to Unix domain socket */
  public static int CURLOPT_UNIX_SOCKET_PATH = CURLOPTTYPE_STRINGPOINT + 231;

  /* Set if we should verify the certificate status. */
  public static int CURLOPT_SSL_VERIFYSTATUS = CURLOPTTYPE_LONG + 232;

  /* Set if we should enable TLS false start. */
  public static int CURLOPT_SSL_FALSESTART = CURLOPTTYPE_LONG + 233;

  /* Do not squash dot-dot sequences */
  public static int CURLOPT_PATH_AS_IS = CURLOPTTYPE_LONG + 234;

  /* Proxy Service Name */
  public static int CURLOPT_PROXY_SERVICE_NAME = CURLOPTTYPE_STRINGPOINT + 235;

  /* Service Name */
  public static int CURLOPT_SERVICE_NAME = CURLOPTTYPE_STRINGPOINT + 236;

  /* Wait/don't wait for pipe/mutex to clarify */
  public static int CURLOPT_PIPEWAIT = CURLOPTTYPE_LONG + 237;

  /* Set the protocol used when curl is given a URL without a protocol */
  public static int CURLOPT_DEFAULT_PROTOCOL = CURLOPTTYPE_STRINGPOINT + 238;

  /* Set stream weight, 1 - 256 (default is 16) */
  public static int CURLOPT_STREAM_WEIGHT = CURLOPTTYPE_LONG + 239;

  /* Set stream dependency on another CURL handle */
  public static int CURLOPT_STREAM_DEPENDS = CURLOPTTYPE_OBJECTPOINT + 240;

  /* Set E-xclusive stream dependency on another CURL handle */
  public static int CURLOPT_STREAM_DEPENDS_E = CURLOPTTYPE_OBJECTPOINT + 241;

  /* Do not send any tftp option requests to the server */
  public static int CURLOPT_TFTP_NO_OPTIONS = CURLOPTTYPE_LONG + 242;

  /* Linked-list of host:port:connect-to-host:connect-to-port,
     overrides the URL's host:port (only for the network layer) */
  public static int CURLOPT_CONNECT_TO = CURLOPTTYPE_OBJECTPOINT + 243;

  /* Set TCP Fast Open */
  public static int CURLOPT_TCP_FASTOPEN = CURLOPTTYPE_LONG + 244;

  /* Continue to send data if the server responds early with an
   * HTTP status code >= 300 */
  public static int CURLOPT_KEEP_SENDING_ON_ERROR = CURLOPTTYPE_LONG + 245;

  /* The CApath or CAfile used to validate the proxy certificate
     this option is used only if PROXY_SSL_VERIFYPEER is true */
  public static int CURLOPT_PROXY_CAINFO = CURLOPTTYPE_STRINGPOINT + 246;

  /* The CApath directory used to validate the proxy certificate
     this option is used only if PROXY_SSL_VERIFYPEER is true */
  public static int CURLOPT_PROXY_CAPATH = CURLOPTTYPE_STRINGPOINT + 247;

  /* Set if we should verify the proxy in ssl handshake,
     set 1 to verify. */
  public static int CURLOPT_PROXY_SSL_VERIFYPEER = CURLOPTTYPE_LONG + 248;

  /* Set if we should verify the Common name from the proxy certificate in ssl
   * handshake, set 1 to check existence, 2 to ensure that it matches
   * the provided hostname. */
  public static int CURLOPT_PROXY_SSL_VERIFYHOST = CURLOPTTYPE_LONG + 249;

  /* What version to specifically try to use for proxy.
     See CURL_SSLVERSION defines below. */
  public static int CURLOPT_PROXY_SSLVERSION = CURLOPTTYPE_LONG + 250;

  /* Set a username for authenticated TLS for proxy */
  public static int CURLOPT_PROXY_TLSAUTH_USERNAME = CURLOPTTYPE_STRINGPOINT + 251;

  /* Set a password for authenticated TLS for proxy */
  public static int CURLOPT_PROXY_TLSAUTH_PASSWORD = CURLOPTTYPE_STRINGPOINT + 252;

  /* Set authentication type for authenticated TLS for proxy */
  public static int CURLOPT_PROXY_TLSAUTH_TYPE = CURLOPTTYPE_STRINGPOINT + 253;

  /* name of the file keeping your private SSL-certificate for proxy */
  public static int CURLOPT_PROXY_SSLCERT = CURLOPTTYPE_STRINGPOINT + 254;

  /* type of the file keeping your SSL-certificate ("DER", "PEM", "ENG") for
     proxy */
  public static int CURLOPT_PROXY_SSLCERTTYPE = CURLOPTTYPE_STRINGPOINT + 255;

  /* name of the file keeping your private SSL-key for proxy */
  public static int CURLOPT_PROXY_SSLKEY = CURLOPTTYPE_STRINGPOINT + 256;

  /* type of the file keeping your private SSL-key ("DER", "PEM", "ENG") for
     proxy */
  public static int CURLOPT_PROXY_SSLKEYTYPE = CURLOPTTYPE_STRINGPOINT + 257;

  /* password for the SSL private key for proxy */
  public static int CURLOPT_PROXY_KEYPASSWD = CURLOPTTYPE_STRINGPOINT + 258;

  /* Specify which SSL ciphers to use for proxy */
  public static int CURLOPT_PROXY_SSL_CIPHER_LIST = CURLOPTTYPE_STRINGPOINT + 259;

  /* CRL file for proxy */
  public static int CURLOPT_PROXY_CRLFILE = CURLOPTTYPE_STRINGPOINT + 260;

  /* Enable/disable specific SSL features with a bitmask for proxy, see
     CURLSSLOPT_* */
  public static int CURLOPT_PROXY_SSL_OPTIONS = CURLOPTTYPE_LONG + 261;

  /* Name of pre proxy to use. */
  public static int CURLOPT_PRE_PROXY = CURLOPTTYPE_STRINGPOINT + 262;

  /* The public key in DER form used to validate the proxy public key
     this option is used only if PROXY_SSL_VERIFYPEER is true */
  public static int CURLOPT_PROXY_PINNEDPUBLICKEY = CURLOPTTYPE_STRINGPOINT + 263;

  public static int CURL_IPRESOLVE_WHATEVER = 0; /* default, resolves addresses to all IP versions that your system allows */
  public static int CURL_IPRESOLVE_V4 = 1; /* resolve to IPv4 addresses */
  public static int CURL_IPRESOLVE_V6 = 2; /* resolve to IPv6 addresses */

  public static int CURL_GLOBAL_SSL = 1<<0;
  public static int CURL_GLOBAL_WIN32 = 1<<1;
  public static int CURL_GLOBAL_ALL = CURL_GLOBAL_SSL|CURL_GLOBAL_WIN32;
  public static int CURL_GLOBAL_NOTHING = 0;
  public static int CURL_GLOBAL_DEFAULT = CURL_GLOBAL_ALL;
  public static int CURL_GLOBAL_ACK_EINTR = 1<<2;

  public static boolean isLongOpt(int opt) {
    return LONG_OPT_SET.contains(opt);
  }

  static {
    OBJECT_POINT_OPT_SET.add(CURLOPT_WRITEDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_READDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_ERRORBUFFER);
    OBJECT_POINT_OPT_SET.add(CURLOPT_POSTFIELDS);
    OBJECT_POINT_OPT_SET.add(CURLOPT_HTTPHEADER);
    OBJECT_POINT_OPT_SET.add(CURLOPT_HTTPPOST);
    OBJECT_POINT_OPT_SET.add(CURLOPT_QUOTE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_HEADERDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_STDERR);
    OBJECT_POINT_OPT_SET.add(CURLOPT_POSTQUOTE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_OBSOLETE40);
    OBJECT_POINT_OPT_SET.add(CURLOPT_PROGRESSDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_XFERINFODATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_TELNETOPTIONS);
    OBJECT_POINT_OPT_SET.add(CURLOPT_PREQUOTE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_DEBUGDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_SHARE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_PRIVATE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_HTTP200ALIASES);
    OBJECT_POINT_OPT_SET.add(CURLOPT_SSL_CTX_DATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_IOCTLDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_SOCKOPTDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_OPENSOCKETDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_COPYPOSTFIELDS);
    OBJECT_POINT_OPT_SET.add(CURLOPT_SEEKDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_SSH_KEYDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_MAIL_RCPT);
    OBJECT_POINT_OPT_SET.add(CURLOPT_INTERLEAVEDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_CHUNK_DATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_FNMATCH_DATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_RESOLVE);
    OBJECT_POINT_OPT_SET.add(CURLOPT_CLOSESOCKETDATA);
    OBJECT_POINT_OPT_SET.add(CURLOPT_PROXYHEADER);
    OBJECT_POINT_OPT_SET.add(CURLOPT_STREAM_DEPENDS);
    OBJECT_POINT_OPT_SET.add(CURLOPT_STREAM_DEPENDS_E);
    OBJECT_POINT_OPT_SET.add(CURLOPT_CONNECT_TO);

    STRING_POINT_OPT_SET.add(CURLOPT_URL);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY);
    STRING_POINT_OPT_SET.add(CURLOPT_USERPWD);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXYUSERPWD);
    STRING_POINT_OPT_SET.add(CURLOPT_RANGE);
    STRING_POINT_OPT_SET.add(CURLOPT_REFERER);
    STRING_POINT_OPT_SET.add(CURLOPT_FTPPORT);
    STRING_POINT_OPT_SET.add(CURLOPT_USERAGENT);
    STRING_POINT_OPT_SET.add(CURLOPT_COOKIE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSLCERT);
    STRING_POINT_OPT_SET.add(CURLOPT_KEYPASSWD);
    STRING_POINT_OPT_SET.add(CURLOPT_COOKIEFILE);
    STRING_POINT_OPT_SET.add(CURLOPT_CUSTOMREQUEST);
    STRING_POINT_OPT_SET.add(CURLOPT_INTERFACE);
    STRING_POINT_OPT_SET.add(CURLOPT_KRBLEVEL);
    STRING_POINT_OPT_SET.add(CURLOPT_CAINFO);
    STRING_POINT_OPT_SET.add(CURLOPT_RANDOM_FILE);
    STRING_POINT_OPT_SET.add(CURLOPT_EGDSOCKET);
    STRING_POINT_OPT_SET.add(CURLOPT_COOKIEJAR);
    STRING_POINT_OPT_SET.add(CURLOPT_SSL_CIPHER_LIST);
    STRING_POINT_OPT_SET.add(CURLOPT_SSLCERTTYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSLKEY);
    STRING_POINT_OPT_SET.add(CURLOPT_SSLKEYTYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSLENGINE);
    STRING_POINT_OPT_SET.add(CURLOPT_CAPATH);
    STRING_POINT_OPT_SET.add(CURLOPT_ACCEPT_ENCODING);
    STRING_POINT_OPT_SET.add(CURLOPT_NETRC_FILE);
    STRING_POINT_OPT_SET.add(CURLOPT_FTP_ACCOUNT);
    STRING_POINT_OPT_SET.add(CURLOPT_COOKIELIST);
    STRING_POINT_OPT_SET.add(CURLOPT_FTP_ALTERNATIVE_TO_USER);
    STRING_POINT_OPT_SET.add(CURLOPT_SSH_PUBLIC_KEYFILE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSH_PRIVATE_KEYFILE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSH_HOST_PUBLIC_KEY_MD5);
    STRING_POINT_OPT_SET.add(CURLOPT_CRLFILE);
    STRING_POINT_OPT_SET.add(CURLOPT_ISSUERCERT);
    STRING_POINT_OPT_SET.add(CURLOPT_USERNAME);
    STRING_POINT_OPT_SET.add(CURLOPT_PASSWORD);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXYUSERNAME);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXYPASSWORD);
    STRING_POINT_OPT_SET.add(CURLOPT_NOPROXY);
    STRING_POINT_OPT_SET.add(CURLOPT_SOCKS5_GSSAPI_SERVICE);
    STRING_POINT_OPT_SET.add(CURLOPT_SSH_KNOWNHOSTS);
    STRING_POINT_OPT_SET.add(CURLOPT_MAIL_FROM);
    STRING_POINT_OPT_SET.add(CURLOPT_RTSP_SESSION_ID);
    STRING_POINT_OPT_SET.add(CURLOPT_RTSP_STREAM_URI);
    STRING_POINT_OPT_SET.add(CURLOPT_RTSP_TRANSPORT);
    STRING_POINT_OPT_SET.add(CURLOPT_TLSAUTH_USERNAME);
    STRING_POINT_OPT_SET.add(CURLOPT_TLSAUTH_PASSWORD);
    STRING_POINT_OPT_SET.add(CURLOPT_TLSAUTH_TYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_DNS_SERVERS);
    STRING_POINT_OPT_SET.add(CURLOPT_MAIL_AUTH);
    STRING_POINT_OPT_SET.add(CURLOPT_XOAUTH2_BEARER);
    STRING_POINT_OPT_SET.add(CURLOPT_DNS_INTERFACE);
    STRING_POINT_OPT_SET.add(CURLOPT_DNS_LOCAL_IP4);
    STRING_POINT_OPT_SET.add(CURLOPT_DNS_LOCAL_IP6);
    STRING_POINT_OPT_SET.add(CURLOPT_LOGIN_OPTIONS);
    STRING_POINT_OPT_SET.add(CURLOPT_PINNEDPUBLICKEY);
    STRING_POINT_OPT_SET.add(CURLOPT_UNIX_SOCKET_PATH);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SERVICE_NAME);
    STRING_POINT_OPT_SET.add(CURLOPT_SERVICE_NAME);
    STRING_POINT_OPT_SET.add(CURLOPT_DEFAULT_PROTOCOL);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_CAINFO);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_CAPATH);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_TLSAUTH_USERNAME);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_TLSAUTH_PASSWORD);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_TLSAUTH_TYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SSLCERT);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SSLCERTTYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SSLKEY);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SSLKEYTYPE);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_KEYPASSWD);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_SSL_CIPHER_LIST);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_CRLFILE);
    STRING_POINT_OPT_SET.add(CURLOPT_PRE_PROXY);
    STRING_POINT_OPT_SET.add(CURLOPT_PROXY_PINNEDPUBLICKEY);

    LONG_OPT_SET.add(CURLOPT_PORT);
    LONG_OPT_SET.add(CURLOPT_TIMEOUT);
    LONG_OPT_SET.add(CURLOPT_INFILESIZE);
    LONG_OPT_SET.add(CURLOPT_LOW_SPEED_LIMIT);
    LONG_OPT_SET.add(CURLOPT_LOW_SPEED_TIME);
    LONG_OPT_SET.add(CURLOPT_RESUME_FROM);
    LONG_OPT_SET.add(CURLOPT_CRLF);
    LONG_OPT_SET.add(CURLOPT_SSLVERSION);
    LONG_OPT_SET.add(CURLOPT_TIMECONDITION);
    LONG_OPT_SET.add(CURLOPT_TIMEVALUE);
    LONG_OPT_SET.add(CURLOPT_VERBOSE);
    LONG_OPT_SET.add(CURLOPT_HEADER);
    LONG_OPT_SET.add(CURLOPT_NOPROGRESS);
    LONG_OPT_SET.add(CURLOPT_NOBODY);
    LONG_OPT_SET.add(CURLOPT_FAILONERROR);
    LONG_OPT_SET.add(CURLOPT_UPLOAD);
    LONG_OPT_SET.add(CURLOPT_POST);
    LONG_OPT_SET.add(CURLOPT_DIRLISTONLY);
    LONG_OPT_SET.add(CURLOPT_APPEND);
    LONG_OPT_SET.add(CURLOPT_NETRC);
    LONG_OPT_SET.add(CURLOPT_FOLLOWLOCATION);
    LONG_OPT_SET.add(CURLOPT_TRANSFERTEXT);
    LONG_OPT_SET.add(CURLOPT_PUT);
    LONG_OPT_SET.add(CURLOPT_AUTOREFERER);
    LONG_OPT_SET.add(CURLOPT_PROXYPORT);
    LONG_OPT_SET.add(CURLOPT_POSTFIELDSIZE);
    LONG_OPT_SET.add(CURLOPT_HTTPPROXYTUNNEL);
    LONG_OPT_SET.add(CURLOPT_SSL_VERIFYPEER);
    LONG_OPT_SET.add(CURLOPT_MAXREDIRS);
    LONG_OPT_SET.add(CURLOPT_FILETIME);
    LONG_OPT_SET.add(CURLOPT_MAXCONNECTS);
    LONG_OPT_SET.add(CURLOPT_OBSOLETE72);
    LONG_OPT_SET.add(CURLOPT_FRESH_CONNECT);
    LONG_OPT_SET.add(CURLOPT_FORBID_REUSE);
    LONG_OPT_SET.add(CURLOPT_CONNECTTIMEOUT);
    LONG_OPT_SET.add(CURLOPT_HTTPGET);
    LONG_OPT_SET.add(CURLOPT_SSL_VERIFYHOST);
    LONG_OPT_SET.add(CURLOPT_HTTP_VERSION);
    LONG_OPT_SET.add(CURLOPT_FTP_USE_EPSV);
    LONG_OPT_SET.add(CURLOPT_SSLENGINE_DEFAULT);
    LONG_OPT_SET.add(CURLOPT_DNS_USE_GLOBAL_CACHE);
    LONG_OPT_SET.add(CURLOPT_DNS_CACHE_TIMEOUT);
    LONG_OPT_SET.add(CURLOPT_COOKIESESSION);
    LONG_OPT_SET.add(CURLOPT_BUFFERSIZE);
    LONG_OPT_SET.add(CURLOPT_NOSIGNAL);
    LONG_OPT_SET.add(CURLOPT_PROXYTYPE);
    LONG_OPT_SET.add(CURLOPT_UNRESTRICTED_AUTH);
    LONG_OPT_SET.add(CURLOPT_FTP_USE_EPRT);
    LONG_OPT_SET.add(CURLOPT_HTTPAUTH);
    LONG_OPT_SET.add(CURLOPT_FTP_CREATE_MISSING_DIRS);
    LONG_OPT_SET.add(CURLOPT_PROXYAUTH);
    LONG_OPT_SET.add(CURLOPT_FTP_RESPONSE_TIMEOUT);
    LONG_OPT_SET.add(CURLOPT_SERVER_RESPONSE_TIMEOUT);
    LONG_OPT_SET.add(CURLOPT_IPRESOLVE);
    LONG_OPT_SET.add(CURLOPT_MAXFILESIZE);
    LONG_OPT_SET.add(CURLOPT_USE_SSL);
    LONG_OPT_SET.add(CURLOPT_TCP_NODELAY);
    LONG_OPT_SET.add(CURLOPT_FTPSSLAUTH);
    LONG_OPT_SET.add(CURLOPT_IGNORE_CONTENT_LENGTH);
    LONG_OPT_SET.add(CURLOPT_FTP_SKIP_PASV_IP);
    LONG_OPT_SET.add(CURLOPT_FTP_FILEMETHOD);
    LONG_OPT_SET.add(CURLOPT_LOCALPORT);
    LONG_OPT_SET.add(CURLOPT_LOCALPORTRANGE);
    LONG_OPT_SET.add(CURLOPT_CONNECT_ONLY);
    LONG_OPT_SET.add(CURLOPT_SSL_SESSIONID_CACHE);
    LONG_OPT_SET.add(CURLOPT_SSH_AUTH_TYPES);
    LONG_OPT_SET.add(CURLOPT_FTP_SSL_CCC);
    LONG_OPT_SET.add(CURLOPT_TIMEOUT_MS);
    LONG_OPT_SET.add(CURLOPT_CONNECTTIMEOUT_MS);
    LONG_OPT_SET.add(CURLOPT_HTTP_TRANSFER_DECODING);
    LONG_OPT_SET.add(CURLOPT_HTTP_CONTENT_DECODING);
    LONG_OPT_SET.add(CURLOPT_NEW_FILE_PERMS);
    LONG_OPT_SET.add(CURLOPT_NEW_DIRECTORY_PERMS);
    LONG_OPT_SET.add(CURLOPT_POSTREDIR);
    LONG_OPT_SET.add(CURLOPT_PROXY_TRANSFER_MODE);
    LONG_OPT_SET.add(CURLOPT_ADDRESS_SCOPE);
    LONG_OPT_SET.add(CURLOPT_CERTINFO);
    LONG_OPT_SET.add(CURLOPT_TFTP_BLKSIZE);
    LONG_OPT_SET.add(CURLOPT_SOCKS5_GSSAPI_NEC);
    LONG_OPT_SET.add(CURLOPT_PROTOCOLS);
    LONG_OPT_SET.add(CURLOPT_REDIR_PROTOCOLS);
    LONG_OPT_SET.add(CURLOPT_FTP_USE_PRET);
    LONG_OPT_SET.add(CURLOPT_RTSP_REQUEST);
    LONG_OPT_SET.add(CURLOPT_RTSP_CLIENT_CSEQ);
    LONG_OPT_SET.add(CURLOPT_RTSP_SERVER_CSEQ);
    LONG_OPT_SET.add(CURLOPT_WILDCARDMATCH);
    LONG_OPT_SET.add(CURLOPT_TRANSFER_ENCODING);
    LONG_OPT_SET.add(CURLOPT_GSSAPI_DELEGATION);
    LONG_OPT_SET.add(CURLOPT_ACCEPTTIMEOUT_MS);
    LONG_OPT_SET.add(CURLOPT_TCP_KEEPALIVE);
    LONG_OPT_SET.add(CURLOPT_TCP_KEEPIDLE);
    LONG_OPT_SET.add(CURLOPT_TCP_KEEPINTVL);
    LONG_OPT_SET.add(CURLOPT_SSL_OPTIONS);
    LONG_OPT_SET.add(CURLOPT_SASL_IR);
    LONG_OPT_SET.add(CURLOPT_SSL_ENABLE_NPN);
    LONG_OPT_SET.add(CURLOPT_SSL_ENABLE_ALPN);
    LONG_OPT_SET.add(CURLOPT_EXPECT_100_TIMEOUT_MS);
    LONG_OPT_SET.add(CURLOPT_HEADEROPT);
    LONG_OPT_SET.add(CURLOPT_SSL_VERIFYSTATUS);
    LONG_OPT_SET.add(CURLOPT_SSL_FALSESTART);
    LONG_OPT_SET.add(CURLOPT_PATH_AS_IS);
    LONG_OPT_SET.add(CURLOPT_PIPEWAIT);
    LONG_OPT_SET.add(CURLOPT_STREAM_WEIGHT);
    LONG_OPT_SET.add(CURLOPT_TFTP_NO_OPTIONS);
    LONG_OPT_SET.add(CURLOPT_TCP_FASTOPEN);
    LONG_OPT_SET.add(CURLOPT_KEEP_SENDING_ON_ERROR);
    LONG_OPT_SET.add(CURLOPT_PROXY_SSL_VERIFYPEER);
    LONG_OPT_SET.add(CURLOPT_PROXY_SSL_VERIFYHOST);
    LONG_OPT_SET.add(CURLOPT_PROXY_SSLVERSION);
    LONG_OPT_SET.add(CURLOPT_PROXY_SSL_OPTIONS);

    FUNCTION_POINT_OPT_SET.add(CURLOPT_WRITEFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_READFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_PROGRESSFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_HEADERFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_DEBUGFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_SSL_CTX_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_IOCTLFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CONV_FROM_NETWORK_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CONV_TO_NETWORK_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CONV_FROM_UTF8_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_SOCKOPTFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_OPENSOCKETFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_SEEKFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_SSH_KEYFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_INTERLEAVEFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CHUNK_BGN_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CHUNK_END_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_FNMATCH_FUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_CLOSESOCKETFUNCTION);
    FUNCTION_POINT_OPT_SET.add(CURLOPT_XFERINFOFUNCTION);
  }
}
