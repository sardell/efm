# (c) 2018-2019 Cloudera, Inc. All rights reserved.
#
#  This code is provided to you pursuant to your written agreement with Cloudera, which may be the terms of the
#  Affero General Public License version 3 (AGPLv3), or pursuant to a written agreement with a third party authorized
#  to distribute this code.  If you do not have a written agreement with Cloudera or with an authorized and
#  properly licensed third party, you do not have any rights to this code.
#
#  If this code is provided to you under the terms of the AGPLv3:
#   (A) CLOUDERA PROVIDES THIS CODE TO YOU WITHOUT WARRANTIES OF ANY KIND;
#   (B) CLOUDERA DISCLAIMS ANY AND ALL EXPRESS AND IMPLIED WARRANTIES WITH RESPECT TO THIS CODE, INCLUDING BUT NOT
#       LIMITED TO IMPLIED WARRANTIES OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE;
#   (C) CLOUDERA IS NOT LIABLE TO YOU, AND WILL NOT DEFEND, INDEMNIFY, OR HOLD YOU HARMLESS FOR ANY CLAIMS ARISING
#       FROM OR RELATED TO THE CODE; AND
#   (D) WITH RESPECT TO YOUR EXERCISE OF ANY RIGHTS GRANTED TO YOU FOR THE CODE, CLOUDERA IS NOT LIABLE FOR ANY
#       DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES INCLUDING, BUT NOT LIMITED
#       TO, DAMAGES RELATED TO LOST REVENUE, LOST PROFITS, LOSS OF INCOME, LOSS OF BUSINESS ADVANTAGE OR
#       UNAVAILABILITY, OR LOSS OR CORRUPTION OF DATA.

FROM openjdk:8-jdk-alpine

ARG SRC_COMMIT_HASH=""
ENV COMMIT_HASH ${SRC_COMMIT_HASH}

EXPOSE 10080

# ADD docker/sh-common /opt/commons
ADD docker/efm-image/script /opt/script

ADD efm/efm-assembly/target/efm-*-bin.tar.gz /opt/efm/

# Default to binding to any interface
RUN sed -i -e "s|^efm.server.address=.*$|efm.server.address=0.0.0.0|" '/opt/efm/efm-1.0.0-SNAPSHOT/conf/efm.properties'

CMD /opt/script/entrypoint.sh
