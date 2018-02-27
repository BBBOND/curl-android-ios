#include <curl/curl.h>
#include <stdlib.h>
#include <string.h>

struct lchttp_error_t {
    CURLcode code;
    char *message;
};

struct lchttp_response_t {
    int code;
    char *header;
    char *text;
};

typedef struct lchttp_error_t lchttp_error_t;
typedef struct lchttp_response_t lchttp_response_t;

lchttp_error_t *lchttp_error_init(void);
lchttp_response_t *lchttp_response_init(void);

CURLcode lchttp_perform(CURL *curl, lchttp_response_t *response, lchttp_error_t *error);

void lchttp_response_destroy(lchttp_response_t *response);
void lchttp_error_destroy(lchttp_error_t *error);